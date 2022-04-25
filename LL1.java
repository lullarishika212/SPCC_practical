import java.util.*;

public class LL1 {

    public static void main(String []args){

        String []non_t = new String[]{"E", "R", "T", "Y", "F"};
        String []term = new String[]{"+", "*", "(", ")", "i", "$"};

        List<String> fs = new ArrayList<>();
        Map<String , Map<String, String>> firstMap = new HashMap<>();
        Map<String, String[]> followMap = new HashMap<>();

        followMap.put("E", new String[]{"$", ")"});
        followMap.put("R", new String[]{"$", ")"});
        followMap.put("T", new String[]{"+","$", ")"});
        followMap.put("Y", new String[]{"+", "$", ")"});
        followMap.put("F", new String[]{"*", "+", "$", ")"});


        firstMap.put("E", new HashMap<>(){{
            put("(", "TR");
            put("i", "TR");
        }});

        firstMap.put("R", new HashMap<>(){{
            put("+", "+TR");
            put("#", "#");
        }});

        firstMap.put("T", new HashMap<>(){{
            put("(", "FY");
            put("i", "FY");

        }});

        firstMap.put("Y", new HashMap<>(){{
            put("*", "*FY");
            put("#", "#");

        }});

        firstMap.put("F", new HashMap<>(){{
            put("(", "(E)");
            put("i", "i");
        }});

        for(int i = 0; i < term.length; i ++){
            System.out.print("\t" + term[i]);
        }

        System.out.println();

        for(int i = 0; i < non_t.length; i ++){
            System.out.print(non_t[i]);

            Map <String, String> prods = firstMap.get(non_t[i]);

            if(prods.containsKey("#")){

                String []arr = followMap.get(non_t[i]);
                Collections.addAll(fs, arr);


            }

            for(int j = 0; j < term.length; j ++){

                if(fs.contains(term[j])){
                    System.out.print("\t#");
                }
                else {
                    System.out.print("\t" + prods.get(term[j]));
                }

            }

            fs.clear();






            System.out.println();

        }




    }

}
