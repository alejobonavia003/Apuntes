
public class Heater{

    // atributo de la consigna
    private double temperature;
    float min;
    float max;
    float increment;


    /**
     * @post construct heater, default temperature: 15.0◦
     */
    public Heater(float minw, float maxs)
    {   
        min = minw;
        max = maxs;
        increment = 5.0f;
        temperature = 15.0f;
    }


    /**
     * @post set increment value 
     */
    public void setIncrement(float value){
        increment = value;
    }

    /**
     * @post increment temperature 5.0◦
     */
    public void warmer() {
        if (temperature<= (max-increment)) {
        temperature= temperature + increment;
        } else {
            System.out.println("Superaria el maximo de temperatura soportado");
        }

    }


    /**
     * @post decrement temperature 5.0◦
     */
    public void cooler() {
        if(temperature >= (min + temperature)){
        temperature= temperature -  increment;
        }
    }


    /**
     * @post show temperature
     */
    public double showTemperature() {
        System.out.println("temperatura actual : " + temperature);
        return temperature;
    }


}
