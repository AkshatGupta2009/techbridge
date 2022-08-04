import java.util.*;
class codeGenerator
{
    void generateMainFunctionHeader(String function_name, String function_return_type, String[] function_arguments)
    {
        System.out.print(function_return_type + " " + function_name + "(" );
        
        int x = 0;
        int y = function_arguments.length;
        y--;
        while(x < y)
        {
            System.out.print(function_arguments[x] + " ");
            x++;
            if( x == y)
            {
                System.out.print(function_arguments[x]);
            }
            else
            {
            System.out.print(function_arguments[x] + ", ");
            x++;
            }
        }
        
        System.out.print(")");
        System.out.println("");
        System.out.print("{");
    }
    
    
    void generateMainFunctionBody(String function_name, String function_return_type, String[] function_arguments)
    {
        System.out.println("");
        System.out.print("    " + "boolean result = false;");
        System.out.println("");
        System.out.print("    return result;");
        System.out.println("");
        System.out.print("}");
    }
    
    
    
    void generateTestCaseFunctionHeader(String function_name, String function_return_type, String[] function_arguments)
    {
        System.out.println("");
        System.out.print("void test_" + function_name + "(");
        
        int x = 0;
        int y = function_arguments.length;
        y--;
        while(x < y)
        {
            System.out.print(function_arguments[x] + " ");
            x++;
            System.out.print(function_arguments[x] + ", ");
            x++;
        }
        
        System.out.print(function_return_type + " expected_result)");
        System.out.println("");
        System.out.print("{");
    }
    
    
    
    void generateTestCaseFunctionBody(String function_name, String function_return_type, String[] function_arguments)
    {
        System.out.println("");
        System.out.print("    " + function_return_type + " actual_result = " + function_name + "(");
        
        int x = 1;
        int y = function_arguments.length;
        y--;
        while(x <= y)
        {
            if(x == y)
            {
                System.out.print(function_arguments[x]);
                break;
            }
            else
            {
                System.out.print(function_arguments[x] + ", ");
                x = x + 2;
            }
        }
        
        System.out.print(");");
        System.out.println(" ");
        System.out.println("");
        System.out.print("    String test_status = \"Failed\";");
        System.out.println("");
        System.out.print("    if (actual_result == expected_result)");
        System.out.println("");
        System.out.print("    {");
        System.out.println("");
        System.out.print("");
        System.out.println("        test_status = \"Passed\";");
        System.out.print("    }");
        System.out.println(" ");
        System.out.println("");
        System.out.print("    StringBiulder builder=new StringBiulder(test_status);");
        
        x = 1;
        y = function_arguments.length;
        y--;
        System.out.println("");
        while(x <= y)
        {
            System.out.println("    builder.append(\"  :" + function_arguments[x] +" -> \");");
            System.out.println("    builder.append(" + function_arguments[x] + ");");
            x = x + 2;
        }
        
        System.out.print("    builder.append(\"  :expected_result -> \");");
        System.out.println("");
        System.out.print("    builder.append(expected_result);");
        System.out.println("");
        System.out.print("    builder.append(\"  :actual_result -> \");");
        System.out.println("");
        System.out.print("    builder.append(actual_result);");
        System.out.println("");
        System.out.print("    System.out.println(builder);");
        System.out.println("");
        System.out.print("}");
    }
    
    
    
    void generateTestSuiteFunctionHeader(String function_name)
    {
        System.out.println("");
        System.out.print("void suit_test_" + function_name + "()");
        System.out.println("");
        System.out.print("{");
    }
    
    
    
    void generateTestSuiteFunctionBody(String function_name)
    {
        System.out.println("");
        System.out.print("    test_" + function_name + "(0, \"Hello\", 0.0, false);");
        System.out.println("");
        System.out.print("}");
    }
    
}



public class CG
{
	public static void main(String[] args) {
	    
        Scanner scan = new Scanner( System.in );
        System.out.print("Number of args: ");
        int n = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Function name: ");
	    String fname = scan.nextLine();
	    
	    System.out.print("Return type: ");
	    String rettype = scan.nextLine();
	    
        String[] arguments = new String[n*2];
	    for(int i = 0;i<n*2;i += 2)
        {
            System.out.print("arg type"  + ": ");
            arguments[i] = scan.next();
            System.out.print("arg name" + ": ");
            arguments[i+1] = scan.next();
        }
        scan.close();
        
        System.out.println("");
        System.out.println("Your code is: ");
        System.out.println("");
	    codeGenerator cgen = new codeGenerator();
	    cgen.generateMainFunctionHeader(fname,rettype,arguments);
	    cgen.generateMainFunctionBody(fname,rettype,arguments);
	    cgen.generateTestCaseFunctionHeader(fname,rettype,arguments);
	    cgen.generateTestCaseFunctionBody(fname,rettype,arguments);
	    cgen.generateTestSuiteFunctionHeader(fname);
	    cgen.generateTestSuiteFunctionBody(fname);
	}
}

