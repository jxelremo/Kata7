package kata7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kata7.Application.swing.HistogramDisplay;
import kata7.Application.swing.HistogramPanel;
import kata7.Application.swing.Toolbar;
import kata7.control.CalculateCommand;
import kata7.control.Command;
import kata7.view.AttributeDialog;
import kata7.view.PopulationDialog;

public class Kata7 extends JFrame{
    private Map <String, Command> commands;
    private PopulationDialog populationDialog;
    private AttributeDialog attributeDialog;
    private HistogramDisplay histogramDisplay;
        
    public static void main(String[] args) {
        new Kata7().setVisible(true);
    }
    
    public Kata7(){
        this.deployUI();
        this.createCommands();
    }

    private void deployUI() {
        this.setTitle("Histogram Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(this);
        this.getContentPane().add(HistogramPanel());
        this.getContentPane().add(toolbar(commands), BorderLayout.NORTH);
    }

    private void createCommands() {
        commands.put("Calculate", new CalculateCommand(attributeDialog, populationDialog, null));
    }

    private HistogramPanel HistogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;
    }

    private JPanel toolbar(Map<String, Command> commands) {
        Toolbar panel = new Toolbar(commands);
        this.attributeDialog = panel;
        this.populationDialog = panel;
        return panel;
    }
}
