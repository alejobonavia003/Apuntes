CPU SIM 4.0.11
August 2017


INSTALLATION INSTRUCTIONS

1.  Download the CPUSim4.0.11.zip file onto your hard disk.

2.  Unzip the CPUSim4.0.11.zip file. The unzipping process
will create a folder called "CPUSim4.0.11" containing 10
documents and a folder.

3.  Install Java 1.8.0_66 or later on your
machine if it is not already there.  Go to the web site
    https://java.com/en/download/
to get the software and to read installation instructions.

4.  Fix, if necessary, your PATH system variable so that
it includes the bin directory (installed as part of the
Java installation) in which the java interpreter
application is located.


STARTING CPU SIM

1.  On a Windows computer, double-click on the "CPUSim4.bat" file.

2.  On a Linux or Macintosh computer or for those who prefer to use the command line,
    (a) open a command or terminal window and navigate to
        the "CPUSim4.0.11" folder.
    (b) Type in one of the following commands (all on one line):
        (Windows users)
          java -cp .;richtextfx-fat-0.6.10.jar;reactfx-2.0-MR.jar 
               -jar CPUSim-4.0.11.jar
        (Mac or Linux users)
          java -cp .:richtextfx-fat-0.6.10.jar:reactfx-2.0-MR.jar 
               -jar CPUSim-4.0.11.jar
    (c) You can also add three optional arguments to the
        command line in any order:
           -m <machine file name>
           -t <text (assembly program) file name>
           -c
        CPU Sim will load the machine indicated by the -m flag and the 
        text file indicated by the -t flag.
        For example, to start up the Wombat1 machine and load the
        W1-0.a assembly language program that appear in the
        SampleAssignments folder, you could type in the following
        command (all on one line) on Windows:
           java   -cp .;richtextfx-fat-0.6.10.jar;reactfx-2.0-MR.jar 
                  -jar CPUSim-4.0.11.jar 
                  -m SampleAssignments/Wombat1.cpu 
                  -t SampleAssignments/W1-0.a
        (This command is, in fact, the command in the "CPUSim.bat" file.)
        If the user does not specify a machine file, a new empty
        machine is opened.
        The -c flag indicates that the Java Swing GUI should not be used
        and instead CPU Sim should run in command line mode.
        Note that if you use the -c flag, you must also
        use the -m and -t flags.  In that case, CPU Sim will load the
        machine indicated by the -m flag and the text file indicated by
        the -t flag and run them without a GUI.  Instead, all user input
        and output is done via the command line.


TUTORIAL

CPU Sim's online help include tutorials on CPU Sim that use the sample assignments.
You can access this help by starting up CPU Sim and then choosing
"General CPU Sim Help" from the Help menu.


CONTACT INFO

Questions and comments should be directed to:
Dale Skrien
Author email:  djskrien@colby.edu
Author home page:  http://www.cs.colby.edu/djskrien
CPU Sim home page:  http://www.cs.colby.edu/djskrien/CPUSim/
