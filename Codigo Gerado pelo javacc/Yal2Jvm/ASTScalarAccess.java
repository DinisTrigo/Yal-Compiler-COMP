package Yal2Jvm;

/* Generated By:JJTree: Do not edit this line. Yal2Jvm.ASTScalarAccess.java Version 4.3 */
 /* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/**
 * ScalarAccess expression generated by JJTree.
 * This method stores the name of variable.
 * ASTScalarAccess overrides the dump method from the SimpleNode class so it can introduce special behaviors for each. And introduces the new method returnIsArray.  
 */
public class ASTScalarAccess extends SimpleNode
{
    /**
     * The id of the variable.
     */
    public String id = null;
    /**
     * If the variable is an array, this variable holds its length. Otherwise, it has the value null.
     */
    public String size = null;
    /**
     * Constructor of the non-terminal expression 'ScalarAccess'.
     * @param id ID of the node.
     */
    public ASTScalarAccess(int id)
    {
        super(id);
    }
    /**
     * Constructor of the non-terminal expression 'ScalarAccess'.
     * @param p Scanner object.
     * @param id ID of the node.
     */
    public ASTScalarAccess(Scanner p, int id)
    {
        super(p, id);
    }

    /**
     * Displays information about this node. Correctly formats the information for more user-friendly reading on the console.
     * The method is overridden in the derived classes whenever special behaviour is necessary.
     * @param prefix The prefix (one or more spaces) to correctly format the information.
     */
    public void dump(String prefix)
    {
        System.out.println(toString(prefix));
        if (id != null)
        {
            System.out.println(prefix + " ID:" + id);
        }
        if (size != null)
        {
            System.out.println(prefix + " Size:" + size);
        }
        if (children != null)
        {
            for (int i = 0; i < children.length; ++i)
            {
                SimpleNode n = (SimpleNode) children[i];
                if (n != null)
                {
                    n.dump(prefix + " ");
                }
            }
        }
    }

    /**
     * This function returns a Boolean variable indicating weather the return of this ScalarAccess is an array or not.
     * @param st The current symbol table to perform the verify the sub-variables used are arrays or not.
     * @return A Boolean value indicating weather the return of this Term is an array or not.
     */
    public Boolean returnIsArray(ST st)
    {
        Boolean thisIsArray = ((FunctionST) st).isVariableArray(this.id);
        if (thisIsArray == null)
        {
            System.out.println("undeclared variable " + this.id);
            st.declareCodeHasSemanticErrors();
            return null;
        } else if (!thisIsArray && size != null)
        {
            System.out.println("trying to access size property of integer variable: " + this.id);
            st.declareCodeHasSemanticErrors();
            return null;
        } else if (thisIsArray && size != null) //return is int
            return false;
        else if (thisIsArray && size == null) //return is the variable, i.e., an array
            return true;
        else if (!thisIsArray && size == null) //return is the variable, i.e., an int
            return false;
        else
            return null;
    }

}
/*
 * JavaCC - OriginalChecksum=3b9f97740b8bffc875526efc74aea151 (do not edit this
 * line)
 */
