import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



    public class fractalArt extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) {
            primaryStage.setTitle("Fractal Shapes");
            Group root = new Group();
            Canvas canvas = new Canvas(1920, 1080);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            drawTree(gc,500, 100, 90, 10, Color.ORANGERED, 10.0);
            root.getChildren().add(canvas);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

        public void drawTree(GraphicsContext gc, int startX, int startY, double angle, int n, Color colorIn, double factor) {
            Color color =  colorIn.deriveColor(-10, 10,10,1);
            gc.setStroke(color);
            if (n == 0){
                return;
            }
            int endX = startX + (int) (Math.cos(Math.toRadians(angle)) * n * factor);
            int endY = startY + (int) (Math.sin(Math.toRadians(angle)) * n * factor);
            gc.strokeLine(startX, startY, endX, endY);
            drawTree(gc, endX, endY, angle - 10, n - 1, color, factor);
            drawTree(gc, endX, endY, angle + 10, n - 1, color, factor);
        }
    }

