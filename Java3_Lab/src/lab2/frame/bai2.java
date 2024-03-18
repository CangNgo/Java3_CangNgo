package lab2.frame;

public class bai2 extends javax.swing.JFrame {

    String so1 = "";
    String so2 = "";
    String so1db = "";
    String so2db = "";
    String pheptinh = "";
    String dacbiet = "";

    public bai2() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void Reset() {
        so1 = "";
        so2 = "";
        so1db = "";
        so2db = "";
        pheptinh = "";
        dacbiet = "";
        lblDisplay.setText("0");
    }

    public void ThucHien() {
        double no1 = Double.parseDouble(so1);
        double no2 = Double.parseDouble(so2);
        switch (pheptinh) {
            case "+": {
                if (so1db.equals("")) {
                    lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                } else {
                    lblBrand.setText(so1db + " " + pheptinh + " " + so2db);
                }
                double result = no1 + no2;
                lblDisplay.setText(String.valueOf(result));
                break;
            }
            case "-": {
                if (so1db.equals("")) {
                    lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                    lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                } else {
                    lblBrand.setText(so1db + " " + pheptinh + " " + so2db);
                    lblBrand.setText(so1db + " " + pheptinh + " " + so2db);
                }
                double result = no1 - no2;
                lblDisplay.setText(String.valueOf(result));
                break;
            }

            case "*": {
                if (so1db.equals("")) {
                    lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                } else {
                    lblBrand.setText(so1db + " " + pheptinh + " " + so2db);
                }
                lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                double result = no1 * no2;
                lblDisplay.setText(String.valueOf(result));
                break;
            }
            case "/": {
                if (so1db.equals("")) {
                    lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                } else {
                    lblBrand.setText(so1db + " " + pheptinh + " " + so2db);
                }
                lblBrand.setText(so1 + " " + pheptinh + " " + so2);
                double result = ((no1 * 10) / no2) * 0.1;
                lblDisplay.setText(String.valueOf(result));
                break;
            }
        }
    }

    public void GetNumber1(String number) {
        String no1 = lblDisplay.getText();
        if (!dacbiet.equals("")) {
            if (pheptinh.length() == 0) {
                so1 = no1 + number;
                lblDisplay.setText(no1 + number);
            } else {
                so2 += number;
                lblDisplay.setText(so2);
            }
            return;
        }
        if (Double.parseDouble(no1) == 0) {
            no1 = "";
        }
        if (pheptinh.length() == 0) {
            so1 = no1 + number;
            lblDisplay.setText(no1 + number);
        } else {
            so2 += number;
            lblDisplay.setText(so2);
        }
    }

    public void operator(String operator) {
        pheptinh = operator;
        lblBrand.setText(so1 + " " + so2);
    }

    public void OperatorDB(String operatorDB) {
        dacbiet = operatorDB;
        String db = "";

        switch (operatorDB) {
            case "sqrt": {
                if (lblDisplay.getText().equals(so1)) {
                    db = so1;
                    so1db = "sqrt(" + db + ")";
                    so1 = String.valueOf(Math.sqrt(Double.parseDouble(so1)));
                } else {
                    db = so2;
                    so2db = "sqrt(" + db + ")";
                    so2 = String.valueOf(Math.sqrt(Double.parseDouble(so2)));
                }
                db = String.valueOf(Math.sqrt(Double.parseDouble(db)));
                lblDisplay.setText("sqrt(" + db + ")");
                break;
            }
            case "%": {
                if (lblDisplay.getText().equals(so1)) {
                    db = so1;
                    so1db = String.valueOf(Double.parseDouble(db) * 0.01);
                    so1 = String.valueOf(Double.parseDouble(so1) * 0.01);
                } else {
                    db = so2;
                    so2db = String.valueOf(Double.parseDouble(db) * 0.01);
                    so2 = String.valueOf(Double.parseDouble(so2) * 0.01);
                }
                db = String.valueOf(Double.parseDouble(db) * 0.01);
                lblDisplay.setText(db);
                break;
            }
            case "1/x": {
                if (lblDisplay.getText().equals(so1)) {
                    db = so1;
                    so1db = String.valueOf(((double) 1 / Double.parseDouble(db)));
                    so1 = String.valueOf(((double) 1 / Double.parseDouble(db)));
                } else {
                    db = so2;
                    so2db = String.valueOf(((double) 1 / Double.parseDouble(db)));
                    so2 = String.valueOf(((double) 1 / Double.parseDouble(db)));
                }
                db = String.valueOf(((double) 1 / Double.parseDouble(db)));
                lblDisplay.setText(db);
                break;
            }
        }
    }

    public void DoiDau() {
        if (pheptinh.equals("")) {
            so1 = String.valueOf(Double.parseDouble(so1) * (-1));
            lblDisplay.setText(so1);
        } else {
            so2 = String.valueOf(Double.parseDouble(so2) * (-1));
            lblDisplay.setText(so2);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDisplay = new javax.swing.JLabel();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnMulti = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnFraction = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRevert = new javax.swing.JButton();
        btnEquals = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblBrand.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblBrand.setText("Casio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBrand)
                                .addGap(22, 22, 22)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(27, Short.MAX_VALUE)
                                .addComponent(lblBrand)
                                .addGap(21, 21, 21)));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        lblDisplay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDisplay.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDisplay)
                                .addGap(25, 25, 25)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDisplay)
                                .addContainerGap()));

        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnSqrt.setText("sqrt");
        btnSqrt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });

        btnDiv.setText("/");
        btnDiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMod.setText("%");
        btnMod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnMulti.setText("*");
        btnMulti.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiActionPerformed(evt);
            }
        });

        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btnFraction.setText("1/x");
        btnFraction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFractionActionPerformed(evt);
            }
        });

        btnMinus.setText("-");
        btnMinus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRevert.setText("+/-");
        btnRevert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRevert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevertActionPerformed(evt);
            }
        });

        btnEquals.setText("=");
        btnEquals.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualsActionPerformed(evt);
            }
        });

        btnDelete.setText("C");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btn0.setText("0");
        btn0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRevert, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnFraction,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnMulti, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(57, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton11)
                                        .addGap(0, 0, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFraction, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRevert, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(191, 191, 191)
                                        .addComponent(jButton11)
                                        .addContainerGap(192, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("2");
    }

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("1");
    }

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {

        OperatorDB("sqrt");
    }

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {

        operator("/");
    }

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("3");
    }

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {

        OperatorDB("%");

    }

    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {

        operator("*");
    }

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("6");
    }

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("5");
    }

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("4");
    }

    private void btnFractionActionPerformed(java.awt.event.ActionEvent evt) {

        OperatorDB("1/x");

    }

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {

        operator("-");
    }

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("8");
    }

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("7");
    }

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("9");
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

        operator("+");
    }

    private void btnRevertActionPerformed(java.awt.event.ActionEvent evt) {

        DoiDau();
    }

    private void btnEqualsActionPerformed(java.awt.event.ActionEvent evt) {

        ThucHien();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        Reset();
    }

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {

        GetNumber1("0");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnEquals;
    private javax.swing.JButton btnFraction;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnMulti;
    private javax.swing.JButton btnRevert;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JButton jButton11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblDisplay;
    // End of variables declaration
}
