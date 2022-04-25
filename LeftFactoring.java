/* lhs : left hand side
 * rhs : right hand side 
 * LF : left factoring 
 * f_count: factoring count that is used to count factor out , i.e X0, X1 , X2  
 * pro: production 
 * cfg: context-free-grammar that refers to the entered grammar by user
 */

public class LeftFactoring {
    public static String cfg_Left_factored = "";
    public static String cfg = "A--> abB | aB | cdg | cdeB | cdfB\n" + ""; // you can add more productions by only
                                                                           // adding \n at the end of the productions.
    public static String Not_LF = "";

    public static boolean left_factoring = false;
    public static int f_count = 0;

    public static void main(String[] args) {

        System.out.println(
                "Context free grammar is \n" + cfg + "\n ----------------------------------------------------------");
        check_factor(cfg);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The result of left factoring is \n"); // productions that don't need to be left factored
                                                                  // out.
        System.out.println(Not_LF);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       
    }

    public static void check_factor(String cfg) {

        String lines[] = cfg.split("\\\n");
        for (String line : lines) {

            line = line.replaceAll("\\s+", ""); // just to remove all white spaces from a line

            String productions[] = line.split("-->", 0); // to split the a line at a time into right hand side and left
                                                         // hand side productions according to -->
            String lhs = productions[0];
            String rhs = productions[1];
            System.out.println("\n*** Left hand side: " + lhs);
            System.out.println("------------------------------------------");
            System.out.println("*** Right hand side: " + rhs);
            System.out.println("------------------------------------------");
            System.out.println("");

            String[] rhs_productions = rhs.split("\\|"); // split right hand side for productions based on |

            left_factoring = false;

            for (int i = 0; i < rhs_productions.length - 1; i++) {
                for (int j = i + 1; j < rhs_productions.length; j++) {

                    if (rhs_productions[i].charAt(0) == rhs_productions[j].charAt(0)
                            && (!rhs_productions[i].equals("epsilon"))) {
                        left_factoring = true;
                    }

                }
            }

            if (left_factoring) {
                System.out.println(" This Grammar needs left factoring!!");
                System.out.println("");

                // Arrays.sort(rhs_productions); // just to sort the array alphabetically
                String common_prefix = "";
                common_prefix = find_common_prefix(rhs_productions);

                System.out.println("--- common prefix is " + common_prefix);
                System.out.println("------------------------------------------");
                left_factor_out(lhs, common_prefix, rhs_productions); // to remove left factoring

            } else {
                Not_LF += line + "\n";
                System.out.println("This grammar does not need left factoring");
                System.out.println("");

            }
        }
    }

    private static void left_factor_out(String lhs, String common_prefix,
            String[] rhs_productions) {
        cfg_Left_factored = lhs + "-->"; // rewrite the productions without left factoring
        for (String pro : rhs_productions) {
            if (!pro.startsWith(common_prefix)) {
                cfg_Left_factored += pro + "|";
            }

        }
        cfg_Left_factored += common_prefix + "X" + f_count + "\n";
        cfg_Left_factored += "X" + f_count + "--> ";
        for (String pro : rhs_productions) {

            if (pro.startsWith(common_prefix)) {
                if (pro.substring(1, pro.length()).length() == 0) {

                    cfg_Left_factored += "epsilon" + "|";
                } else {
                    cfg_Left_factored += pro.substring(1, pro.length()) + "|";
                }

            }

        }
        cfg_Left_factored = cfg_Left_factored.substring(0, cfg_Left_factored.length() - 1); // to remove last | symbol
                                                                                            // at the end
        System.out.println("left factored out \n" + cfg_Left_factored);
        if (left_factoring) {
            f_count++;
            check_factor(cfg_Left_factored);

        }

    }

    public static String find_common_prefix(String[] rhs_productions) {
        String common_prefix = "";
        for (int i = 0; i < rhs_productions.length - 1; i++) {

            for (int j = i + 1; j < rhs_productions.length; j++) {
                if (rhs_productions[i].charAt(0) == rhs_productions[j].charAt(0)) {
                    common_prefix = rhs_productions[i].charAt(0) + "";
                    break;
                }

            }
            if (common_prefix.length() > 0) // initially length of common_prefix is 0 , once the a common prefix is
                                            // found , we don't need the first for to keep looping
                break; // this break correspond to stop first loop for(int =i.....)
        }

        return common_prefix;
    }

}