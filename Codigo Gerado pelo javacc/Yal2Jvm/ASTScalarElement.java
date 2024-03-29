package Yal2Jvm;

/* Generated By:JJTree: Do not edit this line. Yal2Jvm.ASTScalarElement.java Version 4.3 */
 /* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/**
 * ScalarElement expression generated by JJTree.
 * This node name the ID of a variable.
 * ASTScalarElement overrides the dump and fillStFirstPass methods from the SimpleNode class so it can introduce special behaviors for each.   
 */
public class ASTScalarElement extends SimpleNode
{
    /**
     * The id of the scalar element.
     */
    public String scalarID = "";
    /**
     * Constructor of the non-terminal expression 'ScalarElement'.
     * @param id ID of the node.
     */
    public ASTScalarElement(int id)
    {
        super(id);
    }
    /**
     * Constructor of the non-terminal expression 'ScalarElement'.
     * @param p Scanner object.
     * @param id ID of the node.
     */
    public ASTScalarElement(Scanner p, int id)
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
        System.out.println(prefix + "Scalar ID:" + scalarID);
    }

    /**
     * This method is called recursively to go through the entire AST to fill the symbol table.
     * It is Overridden by this derived classes because special behaviour is needed. That special behaviour is implemented by the function because there is no need for specific class since it is only two lines of code.
     * It is placed in the AST because it needs to go through it. The code to perform the actual filling and necessary semantic analysis is placed in different classes, respecting the single responsibility principle.
     * On the first pass, only function definitions are filled in the symbol table. Function bodies will be filled in the second pass.
     * @param st An Object that represents the symbol table to be filled.
     */
    @Override
    public void fillStFirstPass(ST st)
    {
        st.addVariable(scalarID, false);
        super.fillStFirstPass(st);
    }

}
/*
 * JavaCC - OriginalChecksum=c0167e454123aa687bcbe00d7e841ec1 (do not edit this
 * line)
 */
