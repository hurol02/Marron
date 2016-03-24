import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Console;
import java.io.IOException;


class DemoConsoleIO {
    protected class Entry {
        private String prompt;
        private String value;

        public Entry(String p) {
            this.prompt = p;
        }
        public void setPrompt(String p) {
            this.prompt = p;
        }
        public void setValue(String v) {
            this.value = v;
        }
        public String getPrompt() {
            return this.prompt;
        }
        public String getValue() {
            return this.value;
        }
    }

    ArrayList<Entry> inputFields;

    DemoConsoleIO() {
        inputFields = new ArrayList<Entry>(Arrays.asList(new Entry("V1"), new Entry("V2"), new Entry("V3")));
    }
	
    public static void main(String[] args) throws java.io.IOException {
        Console console = System.console();
		if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
		
        DemoConsoleIO d = new DemoConsoleIO();
		
        Iterator<Entry> i = d.inputFields.iterator();
        while (i.hasNext()) {
            Entry e = i.next();
            console.printf("%s: ", e.getPrompt());
            String input = console.readLine();
            e.setValue(input);
        }

        Iterator<Entry> j = d.inputFields.iterator();
        while (j.hasNext()) {
            Entry e = j.next();
            console.printf("%s = %s\n", e.getPrompt(), e.getValue());
        }
    }
}
