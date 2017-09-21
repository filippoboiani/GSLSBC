# IOSL SS 2017: BCIDM

The platoform provides the user with a desktop client developed in electron. The customer takes advantage of this desktop app to manage its identity. The user's identity is stored in the ethereum blockchain and each modification corresponds to a transaction. The transaction is created offline and uploaded to the blockchain with the help of the GSLS node/server. 

The Global Social Lookup System (GSLS) server is implemented in java Spring Boot and has the main purpose of storing a blockchain node and send the signed transactions to the bc network. 

## Identity Management via Blockchain
The aim of this project is to build a blockchain-based, distributed system for self-asserted identities for Distributed Online Social Networks (DOSN) in the Sonic ecosystem.

## Project structure
The project has to main folders: 
- **nodeClient**: contains the code of the client, it is developed in Electron, AngualarJS and Node.js
- **src**: contains the code of the GSLS server: Java SpringBoot, Ethereum Solidity and Web3j. 

## How to run the project
The steps in order to run the project are described in the list below: 
- Run the blockchain client (geth)
- Run the GSLS server 
- Run the desktop client

### 1. Run the blockchain client
In order to run the client, ```geth``` is needed.

The command is the following: 

```geth --fast --cache=512 --rpcapi personal,db,eth,net,web3 --rpc --testnet console```

This command should be specified in the terminal and connects to an Ethereum blockchain test node. The command opens also a console to interact directily with the blockchain client. 

### 2. Run the server 

1. Open the project on an editor such as Intellij IDEA or Eclipse.
2. Run the project inside the editor

### 3. Run the desktop client 

1. From the terminal, go to the ```nodeClient``` repository. 
2. Run the following: 

    ```npm install```
3. Then run: 

    ```npm start```

## How to test the application

Once you run ```npm start``` a window will open. 

You will asked to provide a keystore.json file and a password.

You can use the default keystore called ```default_key_store.json``` inside the ```nodeClient/test/client``` folder. 

The password is ```12345678```
