package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    volatile boolean finish = false;


    @GuardedBy("this")
    private final BlockingQueue<String> files = new LinkedBlockingQueue<>();

    private final List<String> paths = new ArrayList<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                            for (String ext : exts) {
                                if (path.toString().endsWith(ext)) {
                                    files.offer(path.toString());
                                }
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
            }
        };

        Thread read = new Thread() {
            @Override
            public void run() {
                while (!finish) {
                    if (!files.isEmpty()) {
                        String file = files.poll();
                        if (file.contains(text)) {
                            paths.add(file);
                        }
                    }
                }
            }
        };
        search.start();
        read.start();
    }

    synchronized List<String> result() {
        return this.paths;
    }

}
