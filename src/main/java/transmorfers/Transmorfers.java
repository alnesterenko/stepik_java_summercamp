package transmorfers;

interface PrinterInterface {

    void print();

}

class Printer implements PrinterInterface {

    private String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface {
    PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public LeftBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public RightBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}

class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new RightBracketDecorator(new LeftBracketDecorator(new QuotesDecorator(new Printer("Яба-даба-ду!"))));
        printer.print();
    }
}




