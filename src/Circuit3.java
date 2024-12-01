
public class Circuit3 extends Circuit {
    public Circuit3() {
        super();
        backgroundPath = "assets/circuit3.png";
        noResistors = 4;
        noVoltageSources = 1;
        resistorValues = new double[noResistors];
        voltageSourceValues = new double[noVoltageSources];
        resistorVoltages = new int[noResistors];
        missingResistorVoltageIndex = 3;

        randomizeComponentValues();
        setupTextFields();
    }

    @Override
    public boolean isSolved() {
        double R1_R2_series = resistorValues[1] + resistorValues[2];
        double R1_R2_R3_parallel = (R1_R2_series * resistorValues[3]) / (R1_R2_series + resistorValues[3]);
        R1_R2_R3_parallel = Math.round(R1_R2_R3_parallel * 100.0) / 100.0;
        double result = (voltageSourceValues[0] * R1_R2_R3_parallel) / (R1_R2_R3_parallel + resistorValues[0]);
        result = Math.round(result * 100.0) / 100.0;
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        System.out.println("Result: " + result + " User input: " + userInput);
        return result == userInput;
    } 
}
