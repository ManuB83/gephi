/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.ui.ranking.transformer;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.gephi.ranking.api.Ranking;
import org.gephi.ranking.api.SizeTransformer;
import org.gephi.ranking.api.Transformer;
import org.gephi.ui.components.JRangeSlider;

/**
 *
 * @author Mathieu Bastian
 */
public class SizeTransformerPanel extends javax.swing.JPanel {

    private static final int SLIDER_MAXIMUM = 100;
    private SizeTransformer sizeTransformer;
    private Ranking ranking;

    public SizeTransformerPanel(Transformer transformer, Ranking ranking) {
        initComponents();

        sizeTransformer = (SizeTransformer) transformer;
        this.ranking = ranking;

        minSize.setValue(sizeTransformer.getMinSize());
        maxSize.setValue(sizeTransformer.getMaxSize());
        minSize.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                sizeTransformer.setMinSize((Float) minSize.getValue());
            }
        });
        maxSize.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                sizeTransformer.setMaxSize((Float) maxSize.getValue());
            }
        });

        //Range
        JRangeSlider slider = (JRangeSlider) rangeSlider;
        slider.setMinimum(0);
        slider.setMaximum(SLIDER_MAXIMUM);
        slider.setValue(0);
        slider.setUpperValue(SLIDER_MAXIMUM);
        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                JRangeSlider source = (JRangeSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    setRangeValues();
                }
            }
        });
        refreshRangeValues();
    }

    private void setRangeValues() {
        JRangeSlider slider = (JRangeSlider) rangeSlider;
        float low = slider.getValue()/100f;
        float high = slider.getUpperValue()/100f;
        sizeTransformer.setLowerBound(low);
        sizeTransformer.setUpperBound(high);

        lowerBoundLabel.setText(ranking.unNormalize(sizeTransformer.getLowerBound()).toString());
        upperBoundLabel.setText(ranking.unNormalize(sizeTransformer.getUpperBound()).toString());
    }

    private void refreshRangeValues() {
        JRangeSlider slider = (JRangeSlider) rangeSlider;
        slider.setValue((int)(sizeTransformer.getLowerBound()*100f));
        slider.setUpperValue((int)(sizeTransformer.getUpperBound()*100f));

        lowerBoundLabel.setText(ranking.unNormalize(sizeTransformer.getLowerBound()).toString());
        upperBoundLabel.setText(ranking.unNormalize(sizeTransformer.getUpperBound()).toString());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMinSize = new javax.swing.JLabel();
        minSize = new javax.swing.JSpinner();
        labelMaxSize = new javax.swing.JLabel();
        maxSize = new javax.swing.JSpinner();
        labelRange = new javax.swing.JLabel();
        rangeSlider = new JRangeSlider();
        upperBoundLabel = new javax.swing.JLabel();
        lowerBoundLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(225, 114));

        labelMinSize.setText(org.openide.util.NbBundle.getMessage(SizeTransformerPanel.class, "SizeTransformerPanel.labelMinSize.text")); // NOI18N

        minSize.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.1f), null, Float.valueOf(0.5f)));

        labelMaxSize.setText(org.openide.util.NbBundle.getMessage(SizeTransformerPanel.class, "SizeTransformerPanel.labelMaxSize.text")); // NOI18N

        maxSize.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(4.0f), Float.valueOf(0.5f), null, Float.valueOf(0.5f)));

        labelRange.setText(org.openide.util.NbBundle.getMessage(SizeTransformerPanel.class, "SizeTransformerPanel.labelRange.text")); // NOI18N

        rangeSlider.setFocusable(false);
        rangeSlider.setOpaque(false);

        upperBoundLabel.setFont(new java.awt.Font("Tahoma", 0, 10));
        upperBoundLabel.setForeground(new java.awt.Color(102, 102, 102));
        upperBoundLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        upperBoundLabel.setText(org.openide.util.NbBundle.getMessage(SizeTransformerPanel.class, "SizeTransformerPanel.upperBoundLabel.text")); // NOI18N

        lowerBoundLabel.setFont(new java.awt.Font("Tahoma", 0, 10));
        lowerBoundLabel.setForeground(new java.awt.Color(102, 102, 102));
        lowerBoundLabel.setText(org.openide.util.NbBundle.getMessage(SizeTransformerPanel.class, "SizeTransformerPanel.lowerBoundLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelMinSize)
                            .addGap(8, 8, 8)
                            .addComponent(minSize, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(labelMaxSize)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(maxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelRange)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rangeSlider, 0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lowerBoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(upperBoundLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMinSize)
                    .addComponent(minSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMaxSize)
                    .addComponent(maxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRange, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rangeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lowerBoundLabel)
                    .addComponent(upperBoundLabel))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelMaxSize;
    private javax.swing.JLabel labelMinSize;
    private javax.swing.JLabel labelRange;
    private javax.swing.JLabel lowerBoundLabel;
    private javax.swing.JSpinner maxSize;
    private javax.swing.JSpinner minSize;
    private javax.swing.JSlider rangeSlider;
    private javax.swing.JLabel upperBoundLabel;
    // End of variables declaration//GEN-END:variables
}
