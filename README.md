# Password Changer
The Password Changer is a Java application designed to simplify the process of changing passwords on remote servers through SSH connections. This utility reads a configuration file containing server details, usernames, and passwords, establishes SSH connections, and updates the passwords securely. It aims to enhance security by enabling users to efficiently manage and update passwords for various accounts on remote hosts.

## Table of Contents

- Features
- Prerequisites
- Configuration
- Usage
- Components

## Features

- Read server and user details from a configuration file
- Establish SSH connections for secure password updates
- Simplify the process of changing passwords for multiple users
- Enhance security by automating password rotation

## Prerequisites

- Java Development Kit (JDK) installed
- Basic understanding of SSH and remote server management

## Configuration
1. Create a text file with the following format, specifying server and authentication details:
   ```plaintext
   IP Address: 192.168.1.1
   Username: john
   Password: userpassword
   RootPassword: rootpassword
   Users:
   user1:newpassword1
   user2:newpassword2
   ...

## Usage

1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/your-username/password-changer.git
2. Navigate to the project directory:
   ```bash
   cd password-changer
3. Compile the Java application.
   ```bash
   javac passwordchanger/Main.java
4. Run the application, providing the path to your configuration file as a command-line argument.
   ```bash
   java passwordchanger.Main path/to/your/config/file.txt


## Components

- **FileNameChanger**: Ensures consistent formatting of file paths for cross-platform compatibility.
- **FileReader**: Extracts relevant information from the configuration file for further use.
- **RootAccess**: Facilitates gaining root access on remote servers through SSH connections.
- **Session**: Manages SSH connections and channels for remote server interactions.
- **SSHPasswordChange**: Automates the secure process of changing user passwords via SSH.
- **SSHSendCommand**: Sends commands over SSH channels for remote execution.

<br>
<br>
Contributions to the Password Changer are welcome! If you find a bug or have suggestions for improvements, please create an issue in the repository or submit a pull request.
