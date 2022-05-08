import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Display extends Canvas implements Runnable,ActionListener {


    private Thread thread;
    private static String title = "3D model";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static boolean running = false;


    public static void main(String[] args){
        InPutFileReader inPutFileReader = new InPutFileReader("C:\\Users\\zdybe\\Desktop\\3D_model\\src\\shape");
        ArrayList<Line> lines = inPutFileReader.getLines();
        PointConverter pointConverter = new PointConverter(0,0,0,lines);

        JFrame frame = new JFrame();
        DrowLine drowLine = new DrowLine();

        drowLine.setPointConverter(pointConverter);
        frame.addKeyListener(new Rotate(pointConverter));
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Camera");
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drowLine);
    }

    public synchronized void start(){
        running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop(){
        running = false;
        try{
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60;
        double delta = 0;
        int frames =0;

        while(running){
            long now = System.nanoTime();
            delta += (now -lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH *2, HEIGHT*2);


        g.dispose();
        bs.show();
    }

    private void update(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
