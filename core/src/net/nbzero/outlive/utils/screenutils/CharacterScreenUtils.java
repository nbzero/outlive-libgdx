package net.nbzero.outlive.utils.screenutils;

import net.nbzero.outlive.utils.Utils;

public class CharacterScreenUtils {
	// Select Button Checker
	public static void checkSelectButton(int selected, int otherSelect){
		switch(selected){
		case 0:
			Utils.lawButton.setChecked(true);
			if(otherSelect==1)
				Utils.zoroButton.setChecked(true);
			else
				Utils.zoroButton.setChecked(false);
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			break;
		case 1:
			if(otherSelect==0)
				Utils.lawButton.setChecked(true);
			else
				Utils.lawButton.setChecked(false);
			Utils.zoroButton.setChecked(true);
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			break;
		case 2:
			if(otherSelect==0)
				Utils.lawButton.setChecked(true);
			else
				Utils.lawButton.setChecked(false);
			if(otherSelect==1)
				Utils.zoroButton.setChecked(true);
			else
				Utils.zoroButton.setChecked(false);
			Utils.saboButton.setChecked(true);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			if(otherSelect==6)
				Utils.chopperButton.setChecked(true);
			else
				Utils.chopperButton.setChecked(false);
			break;
		case 3:
			if(otherSelect==0)
				Utils.lawButton.setChecked(true);
			else
				Utils.lawButton.setChecked(false);
			if(otherSelect==1)
				Utils.zoroButton.setChecked(true);
			else
				Utils.zoroButton.setChecked(false);
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			Utils.namiButton.setChecked(true);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			if(otherSelect==6)
				Utils.chopperButton.setChecked(true);
			else
				Utils.chopperButton.setChecked(false);
			if(otherSelect==7)
				Utils.usoppButton.setChecked(true);
			else
				Utils.usoppButton.setChecked(false);
			break;
		case 4:
			if(otherSelect==0)
				Utils.lawButton.setChecked(true);
			else
				Utils.lawButton.setChecked(false);
			if(otherSelect==1)
				Utils.zoroButton.setChecked(true);
			else
				Utils.zoroButton.setChecked(false);
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			Utils.sanjiButton.setChecked(true);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			if(otherSelect==6)
				Utils.chopperButton.setChecked(true);
			else
				Utils.chopperButton.setChecked(false);
			if(otherSelect==7)
				Utils.usoppButton.setChecked(true);
			else
				Utils.usoppButton.setChecked(false);
			break;
		case 5:
			if(otherSelect==1)
				Utils.zoroButton.setChecked(true);
			else
				Utils.zoroButton.setChecked(false);
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			Utils.luffyButton.setChecked(true);
			if(otherSelect==6)
				Utils.chopperButton.setChecked(true);
			else
				Utils.chopperButton.setChecked(false);
			if(otherSelect==7)
				Utils.usoppButton.setChecked(true);
			else
				Utils.usoppButton.setChecked(false);
			break;
		case 6:
			if(otherSelect==2)
				Utils.saboButton.setChecked(true);
			else
				Utils.saboButton.setChecked(false);
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			Utils.chopperButton.setChecked(true);
			if(otherSelect==7)
				Utils.usoppButton.setChecked(true);
			else
				Utils.usoppButton.setChecked(false);
			break;
		case 7:
			if(otherSelect==3)
				Utils.namiButton.setChecked(true);
			else
				Utils.namiButton.setChecked(false);
			if(otherSelect==4)
				Utils.sanjiButton.setChecked(true);
			else
				Utils.sanjiButton.setChecked(false);
			if(otherSelect==5)
				Utils.luffyButton.setChecked(true);
			else
				Utils.luffyButton.setChecked(false);
			if(otherSelect==6)
				Utils.chopperButton.setChecked(true);
			else
				Utils.chopperButton.setChecked(false);
			Utils.usoppButton.setChecked(true);
			break;
		}
	}
	public static String getCharName(int selected){
		switch(selected){
		case 0:
			return "Law";
		case 1:
			return "Zoro";
		case 2:
			return "Sabo";
		case 3:
			return "Nami";
		case 4:
			return "Sanji";
		case 5:
			return "Luffy";
		case 6:
			return "Chopper";
		case 7:
			return "Usopp";
		}
		return null;
	}
	
	public static void addP1CharBG(int selected){
		switch(selected){
		case 0:
			Utils.lawBGP1.setVisible(true);
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			break;
		case 1:
			Utils.lawBGP1.setVisible(false);
			Utils.zoroBGP1.setVisible(true);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(false);
			break;
		case 2:
			Utils.lawBGP1.setVisible(false);
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(true);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(false);
			Utils.chopperBGP1.setVisible(false);
			break;
		case 3:
			Utils.lawBGP1.setVisible(false);
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(true);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(false);
			Utils.chopperBGP1.setVisible(false);
			Utils.usoppBGP1.setVisible(false);
			break;
		case 4:
			Utils.lawBGP1.setVisible(false);
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(true);
			Utils.luffyBGP1.setVisible(false);
			Utils.chopperBGP1.setVisible(false);
			Utils.usoppBGP1.setVisible(false);
			break;
		case 5:
			Utils.lawBGP1.setVisible(false);
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(true);
			Utils.chopperBGP1.setVisible(false);
			Utils.usoppBGP1.setVisible(false);
			break;
		case 6:
			Utils.zoroBGP1.setVisible(false);
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(false);
			Utils.chopperBGP1.setVisible(true);
			Utils.usoppBGP1.setVisible(false);
			break;
		case 7:
			Utils.saboBGP1.setVisible(false);
			Utils.namiBGP1.setVisible(false);
			Utils.sanjiBGP1.setVisible(false);
			Utils.luffyBGP1.setVisible(false);
			Utils.chopperBGP1.setVisible(false);
			Utils.usoppBGP1.setVisible(true);
			break;
		}
	}
	
	public static void addP2CharBG(int selected){
		switch(selected){
		case 0:
			Utils.lawBGP2.setVisible(true);
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			break;
		case 1:
			Utils.lawBGP2.setVisible(false);
			Utils.zoroBGP2.setVisible(true);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(false);
			break;
		case 2:
			Utils.lawBGP2.setVisible(false);
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(true);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(false);
			Utils.chopperBGP2.setVisible(false);
			break;
		case 3:
			Utils.lawBGP2.setVisible(false);
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(true);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(false);
			Utils.chopperBGP2.setVisible(false);
			Utils.usoppBGP2.setVisible(false);
			break;
		case 4:
			Utils.lawBGP2.setVisible(false);
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(true);
			Utils.luffyBGP2.setVisible(false);
			Utils.chopperBGP2.setVisible(false);
			Utils.usoppBGP2.setVisible(false);
			break;
		case 5:
			Utils.lawBGP2.setVisible(false);
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(true);
			Utils.chopperBGP2.setVisible(false);
			Utils.usoppBGP2.setVisible(false);
			break;
		case 6:
			Utils.zoroBGP2.setVisible(false);
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(false);
			Utils.chopperBGP2.setVisible(true);
			Utils.usoppBGP2.setVisible(false);
			break;
		case 7:
			Utils.saboBGP2.setVisible(false);
			Utils.namiBGP2.setVisible(false);
			Utils.sanjiBGP2.setVisible(false);
			Utils.luffyBGP2.setVisible(false);
			Utils.chopperBGP2.setVisible(false);
			Utils.usoppBGP2.setVisible(true);
			break;
		}
	}
}
