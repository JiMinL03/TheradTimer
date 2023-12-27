package com.mycompany.threadtimer.GUI;

import java.awt.Color;
import java.io.*;
import java.net.Socket;
import java.util.Calendar;

public class TimerGUI extends javax.swing.JFrame implements Runnable {

    public boolean start = false;
    public boolean stop = false;
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private Thread timerThread;

    public TimerGUI() {
        this.setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.gray);
        setLocationRelativeTo(null);
        setResizable(false);
        jPanel2.setSize(446, 369);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);

                if (start) {
                    getCurrentTime();
                    timer.setText(updateElapsedTime());
                }
            } catch (InterruptedException e) {
                System.out.println("타이머 스레드 중단됨");
                // InterruptedException이 발생하면 쓰레드 종료
                return;
            } catch (Exception e) {
                System.out.println("타이머 오류");
            }
        }
    }

    // 타이머 시작 메서드
    public void startTimer() {
        start = true;
        // 기존 쓰레드가 있다면 중지
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }

        // 새로운 쓰레드 시작
        timerThread = new Thread(this);
        timerThread.start();
    }

    // 타이머 중지 메서드
    public void stopTimer() {
        start = false;
        // 현재 실행 중인 쓰레드를 중지
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }
    }

    // 현재 시간을 문자열로 반환하는 메서드
    public void getCurrentTime() {

        seconds++;

        if (seconds == 60) {
            seconds = 0;
            minutes++;

            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
        }
    }

    public String updateElapsedTime() {
        // 시, 분, 초를 ":"로 구분하여 문자열로 만듭니다.
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        timer = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(52, 93, 93));
        jPanel2.setEnabled(false);

        timer.setFont(new java.awt.Font("LG Smart UI SemiBold", 1, 60)); // NOI18N
        timer.setForeground(new java.awt.Color(51, 51, 51));
        timer.setText("00:00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timer)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        stopButton.setBackground(new java.awt.Color(30, 76, 80));
        stopButton.setFont(new java.awt.Font("LG Smart UI SemiBold", 0, 18)); // NOI18N
        stopButton.setForeground(new java.awt.Color(204, 204, 204));
        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\LG\\Documents\\NetBeansProjects\\ThreadTimer\\close_8532541.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        startButton.setBackground(new java.awt.Color(30, 76, 80));
        startButton.setFont(new java.awt.Font("LG Smart UI SemiBold", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(204, 204, 204));
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel2MousePressed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        start = true;
        startTimer();
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        stop = true;
        stopTimer();
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables

}
