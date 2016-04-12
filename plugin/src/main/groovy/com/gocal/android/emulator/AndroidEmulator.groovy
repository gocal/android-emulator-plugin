package com.gocal.android.emulator

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AndroidEmulator {

    Logger logger = LoggerFactory.getLogger(AndroidEmulator.simpleName)

    String emulatorPath;

    AndroidEmulator(String emulatorPath) {
        this.emulatorPath = emulatorPath;
    }

    public String getVersion() {
        String versionString = runEmulatorGetOutput(new EmulatorOption(EmulatorParameter.VERSION)).get(0)
        return versionString.substring(versionString.indexOf("version"))
    }

    public void start() {
        logger.error("start")
        runEmulator(new EmulatorOption(EmulatorParameter.AVD, "nexus"))
    }

    private Process runEmulator(EmulatorOption... options) {
        String[] command = getEmulatorLaunchCommand(options);
        try {
            return Runtime.getRuntime().exec(command)
        }
        catch (IOException ioe) {
            // we'll return false;
        }
        catch (InterruptedException ie) {
            // we'll return false;
        }
    }

    private List<String> runEmulatorGetOutput(EmulatorOption... options) {
        def process = runEmulator(options)
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()))
        def lines = new ArrayList<String>()
        String output = null;
        while ((output = stdInput.readLine()) != null) {
            lines.add(output)
        }
        return lines
    }

    private String[] getEmulatorLaunchCommand(EmulatorOption... options) {
        List<String> command = new ArrayList<String>(4)
        command.add(emulatorPath);

        for (EmulatorOption option : options) {
            command.add("-" + option.getParameter().getValue())
            if (option.hasValues()) {
                command.addAll(option.getValues())
            }
        }
        return command.toArray(new String[command.size()])
    }
}
