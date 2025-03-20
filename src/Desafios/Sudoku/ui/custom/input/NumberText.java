package Desafios.Sudoku.ui.custom.input;

import Desafios.Sudoku.model.Space;
import Desafios.Sudoku.service.EventEnum;
import Desafios.Sudoku.service.EventListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class NumberText extends JTextField implements EventListener {
    private final Space space;


    public NumberText(Space space) {
        this.space = space;
        Dimension dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());

        if (space.isFixed()){
            this.setText(space.getActual().toString());
        }

        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeSapce();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeSapce();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeSapce();

            }

            private void changeSapce(){
                if (getText().isEmpty()){
                    space.clearSpace();
                    return;
                }
                space.setActual(Integer.parseInt(getText()));
            }
        });
    }

    @Override
    public void update(EventEnum eventType) {
        if (eventType.equals(EventEnum.CLEAR_SPACE) && (this.isEnabled())){
            this.setText("");
        }
    }
}
