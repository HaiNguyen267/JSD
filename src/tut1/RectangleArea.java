package tut1;

public class RectangleArea {
    // this class has 2 fields and a method to calculate the area of the rectangle
    int length;
    int width;

    public RectangleArea(int length, int width) {
        this.length = length;
        this.width = width;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        // create an rectangle object
        RectangleArea rectangle = new RectangleArea(5, 10);
        // print the area of the rectangle
        System.out.println("Area of the rectangle is: " + rectangle.getArea());
    }

}

//q: how to generate jar file from a java file in IntelliJ?
//a: File -> Project Structure -> Artifacts -> + -> JAR -> From modules with dependencies...
// q: no i mean create new jar file from exiting java file
// a: File -> Project Structure -> Artifacts -> + -> JAR -> From modules with dependencies...

// q: how run jar file from command line?
// a: java -jar <jar file name>.jar
// q: i got this error: no main manifest attribute, in linhdz.jar
// a: you need to specify the main class in the manifest file

// q: what is ClassLOader in Java

