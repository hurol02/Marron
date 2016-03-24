import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


class DemoBufferedIO {
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

    DemoBufferedIO() {
        inputFields = new ArrayList<Entry>(Arrays.asList(new Entry("V1"), new Entry("V2"), new Entry("V3")));
    }

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		if (cin == null) {
            System.err.println("No standard input.");
            System.exit(1);
        }
		
        DemoBufferedIO d = new DemoBufferedIO();
		
		try {
			Iterator<Entry> i = d.inputFields.iterator();
			while (i.hasNext()) {
				Entry e = i.next();
				System.out.format("%s: ", e.getPrompt());
				String input = cin.readLine();
				e.setValue(input);
			}
			
			System.out.println();
			
			Iterator<Entry> j = d.inputFields.iterator();
			while (j.hasNext()) {
				Entry e = j.next();
				System.out.format("%s = %s\n", e.getPrompt(), e.getValue());
			}
		} catch (IOException iox) {
			System.err.format("IOException: %s\n", iox.getMessage());
		}
	}
}
