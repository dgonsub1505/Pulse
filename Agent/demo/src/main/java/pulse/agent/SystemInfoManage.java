package pulse.agent;

import java.util.ArrayList;
import java.util.HashMap;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import oshi.hardware.*;
import oshi.hardware.CentralProcessor.LogicalProcessor;
import oshi.hardware.CentralProcessor.PhysicalProcessor;

public class SystemInfoManage {
    private static SystemInfo system = new SystemInfo();

    public static class getHardware {
        private static HardwareAbstractionLayer hdw = system.getHardware();

        public static class getCpu {
            private static CentralProcessor cpu = hdw.getProcessor();

            public CentralProcessor getFullInfo() {
                return cpu;
            }

            public static String getName() {
                return cpu.getProcessorIdentifier().getName();
            }

            public static Double getPercentage() {
                return Math.round(cpu.getSystemCpuLoad(0) * 10000) / 100.0;
            }

            public static int getCoreAmount() {
                return cpu.getPhysicalProcessorCount();
            }

            public static int getThreadAmount() {
                return cpu.getLogicalProcessorCount();
            }

            public static class getCores {
                private static final ArrayList<PhysicalProcessor> cores = new ArrayList<>(cpu.getPhysicalProcessors());

                public static ArrayList<String> getNames() {
                    ArrayList<String> coresNames = new ArrayList<String>();
                    for (PhysicalProcessor core : cores) {
                        coresNames.add(String.valueOf(core.getPhysicalProcessorNumber() + 1));
                    }
                    return coresNames;
                }

                public static HashMap<String, Double> getPercentages() {
                    HashMap<String, Double> coresPercentages = new HashMap<String, Double>();
                    for (PhysicalProcessor core : cores) {
                        coresPercentages.put(String.valueOf(core.getPhysicalProcessorNumber() + 1), 2.0);
                    }
                    return coresPercentages;
                }
            }

            public static class getThreads {
                private static final ArrayList<LogicalProcessor> threads = new ArrayList<>(cpu.getLogicalProcessors());

                public static ArrayList<String> getNames() {
                    ArrayList<String> threadsNames = new ArrayList<String>();
                    for (LogicalProcessor thread : threads) {
                        threadsNames.add(String.valueOf(thread.getPhysicalProcessorNumber() + 1));
                    }
                    return threadsNames;
                }

                public static HashMap<String, Double> getPercentages() {
                    HashMap<String, Double> threadsPercentages = new HashMap<String, Double>();
                    for (LogicalProcessor thread : threads) {
                        threadsPercentages.put(String.valueOf(thread.getPhysicalProcessorNumber() + 1), 2.0);
                    }
                    return threadsPercentages;
                }
            }

        }

        public static class getSensors {
            final static Sensors sensors = hdw.getSensors();

            public static Double getCpuTemp() {
                return sensors.getCpuTemperature();
            }

            public static int[] getFanRpm() {
                return sensors.getFanSpeeds();
            }

        }
    }

    public static class getOs {
        private static OperatingSystem os = system.getOperatingSystem();

    }

    public void close() {
    }
}
