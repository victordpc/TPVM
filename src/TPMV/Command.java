/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPMV;

/**
 *
 * @author yhondri
 */
public class Command {

    private final ENUM_COMMAND command;
    private ByteCode instruction;
    private int replace;

    public Command(ENUM_COMMAND command) {
        this.command = command;
    }
    
    public Command(ENUM_COMMAND command, ByteCode instruction) {
        this.command = command;
        this.instruction = instruction;
    }
      
    public Command(ENUM_COMMAND command, int replace) {
        this.command = command;
        this.replace = replace;
    }

    public boolean execute(Engine engine) {
        boolean success = true;
        switch (command) {
            case HELP:
                engine.executeHelp();
                break;
            case QUIT:
                engine.executeQuit();
                break;
            case NEWINST:
                engine.executeNewInst(instruction);
                break;
            case RUN:
                engine.executeRun();
                break;
            case RESET:
                engine.executeReset();
                break;
            case REPLACE:
                engine.executeReplace(replace);
                break;
            default:
                success = false;
                break;
        }
        return success;
    }
    
    public ByteCode getByteCode() {
        return instruction;
    }
}
