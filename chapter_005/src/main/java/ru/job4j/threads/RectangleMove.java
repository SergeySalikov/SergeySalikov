package ru.job4j.threads;

import javafx.scene.shape.Rectangle;

public class RectangleMove extends Thread {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        boolean bound = false;
        while (!this.isInterrupted()) {
            if (rect.getX() == 300) {
                bound = true;
            } else if (rect.getX() == 0) {
                bound = false;
            }
            if (!bound) {
                this.rect.setX(this.rect.getX() + 1);
            } else {
                this.rect.setX(this.rect.getX() - 1);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}