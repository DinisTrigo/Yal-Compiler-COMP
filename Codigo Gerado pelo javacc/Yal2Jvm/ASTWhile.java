package Yal2Jvm;

import Yal2Jvm.CodeGeneration.IR.*;
import Yal2Jvm.CodeGeneration.IRFilling.WhileIRFiller;

import java.util.HashSet;

/* Generated By:JJTree: Do not edit this line. Yal2Jvm.ASTWhile.java Version 4.3 */
 /* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/**
 * While expression generated by JJTree.
 * ASTWhile overrides the dump, verifyInitialization, and fillIRSecondPass methods from the SimpleNode class so it can introduce special behaviors for each.  
 */
public class ASTWhile extends SimpleNode
{
    /**
     * Is responsible for filling the IR.
     */
    private final WhileIRFiller whileIRFiller = new WhileIRFiller(this);
    /**
     * Constructor of the non-terminal expression 'While'.
     * @param id ID of the node.
     */
    public ASTWhile(int id)
    {
        super(id);
    }
    /**
     * Constructor of the non-terminal expression 'While'.
     * @param p Scanner object.
     * @param id ID of the node.
     */
    public ASTWhile(Scanner p, int id)
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
     * This method is called recursively to go through the entire AST verify the variable initialization.
     * It is Overridden by this derived classes because special behaviour is needed. That special behaviour is implemented by the function because there is no need for specific class since it is only two lines of code.
     * It is placed in the AST because it needs to go through it. The code to perform the actual verification of the variable initialization is placed in different classes, respecting the single responsibility principle.
     * @param initializedVariables A set containing the currently initialized variables (in the current node of the AST). As new variables get initialized, they are added to the set.
     * @param st An Object that represents the already filled symbol table.
     * @return The set of initialized variables after the current AST node (new variables could eventually have been added to the set it received as parameter if they actually for initialized in the current AST node).
     */
    public HashSet verifyInitialization(HashSet<String> initializedVariables, ST st)
    {
        super.verifyInitialization(new HashSet<String>(initializedVariables), st);
        return initializedVariables;
    }

    /**
     * This method is called recursively to go through the entire AST to fill the intermediate representation (IR).
     * It is Overridden by this derived classes because special behaviour is needed. That special behaviour is implemented by the function fillIRSecondPass on the class WhileIRFiller.
     * It is placed in the AST because it needs to go through it. The code to perform the actual filling is placed in different classes, respecting the single responsibility principle.
     * On the first pass, only function definitions are filled in the intermediate representation. Function bodies will be filled in the second pass.
     * @param st An Object that represents the already filled symbol table.
     * @param irContainer A class representing the intermediate representation to be filled.
     * @param currentBlock A class representing the current block on the IR of this AST node. This is used to perform branching on certain conditions.
     */
    public void fillIRSecondPass(ST st, IRContainer irContainer, BasicBlock currentBlock)
    {
        whileIRFiller.fillIRSecondPass(st, irContainer, currentBlock);
    }
}
/*
 * JavaCC - OriginalChecksum=bcd154a28fc0cdef9d8c13c3cd720e27 (do not edit this
 * line)
 */
