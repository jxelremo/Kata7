package kata7.control;

import kata7.view.HistogramBuilder;
import kata7.view.AttributeDialog;
import kata7.Application.swing.HistogramPanel;
import kata7.view.PopulationDialog;

public class CalculateCommand implements Command {

    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramPanel display;
    
    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramPanel display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }
    
    @Override
    public void execute() {
        HistogramBuilder histogram = new HistogramBuilder(populationDialog.population().build(attributeDialog.attribute()));
    }
    
}