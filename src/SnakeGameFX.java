/*
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGameFX extends Application {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

    private List<Point> snakeBody;
    private Point apple;
    private Direction direction;
    private boolean running;
    private int applesEaten;
    private Random random;
    private Button restartButton;

    private Canvas canvas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        snakeBody = new ArrayList<>();
        random = new Random();
        direction = Direction.RIGHT;
        applesEaten = 0;

        initializeGame();

        restartButton = new Button("Restart");
        restartButton.setVisible(false); // Initially invisible
        restartButton.(e -> restartGame());

        StackPane root = new StackPane();
        root.getChildren().addAll(canvas, restartButton);

        Scene scene = new Scene(new Group(canvas));
        scene.setOnKeyPressed(this::handleKeyInput);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 75_000_000) {
                    if (running) {
                        move();
                        checkApple();
                        checkCollisions();
                        draw(gc);
                    } else {
                        drawGameOver(gc);
                    }
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    private void initializeGame() {
        snakeBody.clear();
        for (int i = 0; i < 6; i++) {
            snakeBody.add(new Point(UNIT_SIZE * 6 - i * UNIT_SIZE, UNIT_SIZE * 6));
        }
        newApple();
        running = true;
    }

    private void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK); // Set your desired background color here
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Draw apple
        gc.setFill(Color.RED);
        gc.fillOval(apple.x, apple.y, UNIT_SIZE, UNIT_SIZE);

        // Draw snake
        for (int i = 0; i < snakeBody.size(); i++) {
            if (i == 0) {
                gc.setFill(Color.CYAN);
            } else {
                gc.setFill(Color.GREEN);
            }
            gc.fillOval(snakeBody.get(i).x, snakeBody.get(i).y, UNIT_SIZE, UNIT_SIZE);
        }

        // Draw score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Ink Free", 30));
        gc.fillText("Score: " + applesEaten, SCREEN_WIDTH / 2 - 60, 30);
    }

    private void newApple() {
        apple = new Point(random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE,
                          random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE);
    }

    private void move() {
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            snakeBody.set(i, new Point(snakeBody.get(i - 1).x, snakeBody.get(i - 1).y));
        }

        Point head = snakeBody.get(0);
            switch (direction) {
                case UP:
                    snakeBody.set(0, new Point(head.x, head.y - UNIT_SIZE));
                    break;
                case DOWN:
                    snakeBody.set(0, new Point(head.x, head.y + UNIT_SIZE));
                    break;
                case LEFT:
                    snakeBody.set(0, new Point(head.x - UNIT_SIZE, head.y));
                    break;
                case RIGHT:
                    snakeBody.set(0, new Point(head.x + UNIT_SIZE, head.y));
                    break;
            }
    }

    private void checkApple() {
        if (snakeBody.get(0).equals(apple)) {
            applesEaten++;
            snakeBody.add(new Point(snakeBody.get(snakeBody.size() - 1).x, snakeBody.get(snakeBody.size() - 1).y));
            newApple();
        }
    }

    private void checkCollisions() {
        Point head = snakeBody.get(0);
        // Check if snake hits itself
        for (int i = 1; i < snakeBody.size(); i++) {
            if (head.equals(snakeBody.get(i))) {
                running = false;
                return;
            }
        }
        // Check if snake hits walls
        if (head.x < 0 || head.x >= SCREEN_WIDTH || head.y < 0 || head.y >= SCREEN_HEIGHT) {
            running = false;
        }
    }

    private void handleKeyInput(KeyEvent event) {
        if (event.getCode() == KeyCode.UP && direction != Direction.DOWN) {
            direction = Direction.UP;
        } else if (event.getCode() == KeyCode.DOWN && direction != Direction.UP) {
            direction = Direction.DOWN;
        } else if (event.getCode() == KeyCode.LEFT && direction != Direction.RIGHT) {
            direction = Direction.LEFT;
        } else if (event.getCode() == KeyCode.RIGHT && direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }
    }

    private void drawGameOver(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.setFont(new Font("Ink Free", 75));
        gc.fillText("Game Over", SCREEN_WIDTH / 4, SCREEN_HEIGHT / 2);
    }

    private void restartGame() {
        applesEaten = 0;
        direction = Direction.RIGHT;
        initializeGame();
        restartButton.setVisible(false);
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGameFX extends Application {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

    private List<Point> snakeBody;
    private Point apple;
    private Direction direction;
    private boolean running;
    private int applesEaten;
    private Random random;

    private Canvas canvas;
    private Button restartButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        snakeBody = new ArrayList<>();
        random = new Random();
        direction = Direction.RIGHT;
        applesEaten = 0;

        initializeGame();

        // Set up restart button
        restartButton = new Button("Restart");
        restartButton.setMaxWidth(100);
        restartButton.setVisible(false); // Initially invisible
        restartButton.setOnAction(e -> restartGame()); // Corrected setOnAction syntax
        //restartButton.relocate(300,450);

        StackPane root = new StackPane();
        root.getChildren().addAll(canvas, restartButton); // Corrected method to add children

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::handleKeyInput);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 75_000_000) {
                    if (running) {
                        move();
                        checkApple();
                        checkCollisions();
                        draw(gc);
                    } else {
                        drawGameOver(gc);
                    }
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    private void initializeGame() {
        snakeBody.clear();
        for (int i = 0; i < 6; i++) {
            snakeBody.add(new Point(UNIT_SIZE * 6 - i * UNIT_SIZE, UNIT_SIZE * 6));
        }
        newApple();
        running = true;
    }

    private void draw(GraphicsContext gc) {
        // Clear the canvas with a background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Draw apple
        gc.setFill(Color.RED);
        gc.fillOval(apple.x, apple.y, UNIT_SIZE, UNIT_SIZE);

        // Draw snake
        for (int i = 0; i < snakeBody.size(); i++) {
            if (i == 0) {
                gc.setFill(Color.LAVENDER);
            } else {
                gc.setFill(Color.LAVENDERBLUSH);
            }
            gc.fillOval(snakeBody.get(i).x, snakeBody.get(i).y, UNIT_SIZE, UNIT_SIZE);
        }

        // Draw score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Ink Free", 30));
        gc.fillText("Score: " + applesEaten, SCREEN_WIDTH / 2 - 60, 30);
    }

    private void newApple() {
        apple = new Point(random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE,
                random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE);
    }

    private void move() {
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            snakeBody.set(i, new Point(snakeBody.get(i - 1).x, snakeBody.get(i - 1).y));
        }

        Point head = snakeBody.get(0);
        switch (direction) {
            case UP:
                snakeBody.set(0, new Point(head.x, head.y - UNIT_SIZE));
                break;
            case DOWN:
                snakeBody.set(0, new Point(head.x, head.y + UNIT_SIZE));
                break;
            case LEFT:
                snakeBody.set(0, new Point(head.x - UNIT_SIZE, head.y));
                break;
            case RIGHT:
                snakeBody.set(0, new Point(head.x + UNIT_SIZE, head.y));
                break;
        }
    }

    private void checkApple() {
        if (snakeBody.get(0).equals(apple)) {
            applesEaten++;
            snakeBody.add(new Point(snakeBody.get(snakeBody.size() - 1).x, snakeBody.get(snakeBody.size() - 1).y));
            newApple();
        }
    }

    private void checkCollisions() {
        Point head = snakeBody.get(0);
        // Check if snake hits itself
        for (int i = 1; i < snakeBody.size(); i++) {
            if (head.equals(snakeBody.get(i))) {
                running = false;
                restartButton.setVisible(true);
                return;
            }
        }
        // Check if snake hits walls
        if (head.x < 0 || head.x >= SCREEN_WIDTH || head.y < 0 || head.y >= SCREEN_HEIGHT) {
            running = false;
            restartButton.setVisible(true);
        }
    }

    private void handleKeyInput(KeyEvent event) {
        if (event.getCode() == KeyCode.UP && direction != Direction.DOWN) {
            direction = Direction.UP;
        } else if (event.getCode() == KeyCode.DOWN && direction != Direction.UP) {
            direction = Direction.DOWN;
        } else if (event.getCode() == KeyCode.LEFT && direction != Direction.RIGHT) {
            direction = Direction.LEFT;
        } else if (event.getCode() == KeyCode.RIGHT && direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }
    }

    private void drawGameOver(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.setFont(new Font("Ink Free", 75));
        gc.fillText("Game Over", SCREEN_WIDTH / 4, SCREEN_HEIGHT / 2);
    }

    private void restartGame() {
        applesEaten = 0;
        direction = Direction.RIGHT;
        initializeGame();
        restartButton.setVisible(false);
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
