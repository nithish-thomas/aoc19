package executionEngine.prog.robo.asci;

public class ASCIMap {

    public static char[][] convertToArray(String string){
        final char[] chars = string.toCharArray();
        final String[] rows = string.split("\\n");
        char[][] res=new char[rows.length][];

        for (int i = 0; i < rows.length ; i++) {
            res[i]= rows[i].toCharArray();
        }
        return res;
    }

}
