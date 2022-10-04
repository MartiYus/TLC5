public class Pet {
    protected String name;
    protected String colour;

    public Pet(String name, String colour){
        this.name = name;
        this.colour = colour;
    }

    //setter
    public void setColour(String colour){
        if (colour != "black") {
            this.colour = colour;
        }
    }

    //getter
    public String getColour(){
        return this.colour;
    }
}
