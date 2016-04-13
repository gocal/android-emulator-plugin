package com.gocal.android.emulator

import com.android.ddmlib.AndroidDebugBridge
import com.gocal.android.emulator.avd.Avd
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AndroidEmulator {

    Logger logger = LoggerFactory.getLogger(AndroidEmulator.simpleName)

    String emulatorPath
    String adbPath
    AndroidDebugBridge androidDebugBridge
    Avd avd

    AndroidEmulator(String emulatorPath, String adbPath) {
        this.emulatorPath = emulatorPath;
        this.adbPath = adbPath;
        this.androidDebugBridge = AndroidDebugBridge.createBridge(adbPath, false);
    }

    public String getVersion() {
        String versionString = runEmulatorGetOutput(new EmulatorOption(EmulatorParameter.VERSION)).get(0)
        return versionString.substring(versionString.indexOf("version") + 9)
    }

    public void start() {
        logger.error("start")
        runEmulator(new EmulatorOption(EmulatorParameter.AVD, avd.name),
                    new EmulatorOption(EmulatorParameter.NO_WINDOW))
    }

    void stop() {
        executeCommand(adbPath, "emu", "kill")
    }

    private Process runEmulator(EmulatorOption... options) {
        String[] command = getEmulatorLaunchCommand(options);
        return executeCommand(command)
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

    private Process executeCommand(String... parameters) {
        logger.error(parameters.join(" "))
        try {
            return Runtime.getRuntime().exec(parameters)
        }
        catch (IOException ioe) {
            // we'll return false;
        }
        catch (InterruptedException ie) {
            // we'll return false;
        }
    }
}
