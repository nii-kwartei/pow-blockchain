package proofchain;

import java.util.ArrayList; 
import com.google.gson.GsonBuilder;


/**
 * 
 * 
 * Blockchain: Proof Of Work
 * 
 * A Java program to demonstrate the concept of proof-of-work in blockchain technology by:
 * 1. Creating (very) basic ‘blockchain’.
 * 2. Implement a simple proof of work ( mining ) system.
 * 
 * 
 * @mainAuthor Kass
 * 
 * @Coauthors Khen Brian N. K. Quartey & Pasalkar Mohini Ramdas
 */

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 1;

    public static void main(String[] args) {
	// write your code here

        //add our blocks to the blockchain ArrayList:
        System.out.println("Trying to Mine block 1... ");
        TransactionRecord stockRecond = new TransactionRecord();
        stockRecond.setTransactionID("1234");
        stockRecond.setTransactionType("PURCHASE");
        stockRecond.setTransactionStatus("Successful");
        stockRecond.setTransactionDate("06/29/2019");
        stockRecond.setTransactionAmount("500");
        blockchain.add(new Block(stockRecond.toString(), "0"));
        blockchain.get(0).mineBlock(difficulty);

        
        System.out.println("Trying to Mine block 2... ");
        Lecturer lecturer = new Lecturer();
        lecturer.setLecturerID("2343");
        lecturer.setLecturerName("Dr. Francis Simsons");
        lecturer.setLecturerCourse("Blockchain Techlogy");
        blockchain.add(new Block(lecturer.toString(),blockchain.get(blockchain.size()-1).hash));
        blockchain.get(1).mineBlock(2);

        System.out.println("Trying to Mine block 3... ");
        Asset asset = new Asset();
        asset.setAssetID("3432");
        asset.setAssetType("BUILDING");
        asset.setAssetName("Pentagon");
        asset.setAssetLocation("Oberes Tor");
        blockchain.add(new Block(asset.toString(),blockchain.get(blockchain.size()-1).hash));
        blockchain.get(2).mineBlock(6);
        
        // check whether our blokcchain is valid
        System.out.println("\nBlockchain is Valid: " + isChainValid());

        // format data into Json
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
        
    }
    
    // method for checking the integriy of the blockchain
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
