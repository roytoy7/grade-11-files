import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.Scanner;

public class KirbyKosmos extends JPanel implements KeyListener, MouseListener, Runnable{

    // Global Variables
    // Gamestate key
    // gs0 - menu
    // gs1 - tutorial
    // gs2 - credits
    // gs3 - highscore
    // gs4 - in-game screen
    // gs5 - winning
    // gs6 - losing
    public static int gamestate = 0;
    public static BufferedImage gs0;
    public static BufferedImage[] gs1 = new BufferedImage[3];
    public static BufferedImage gs2;
    public static BufferedImage gs3;
    public static BufferedImage gs4;
    public static BufferedImage gs5;
    public static BufferedImage gs6;
    public static BufferedImage[] lifeImages = new BufferedImage[3];
    public static BufferedImage cookie;
    public static BufferedImage[] numbers = new BufferedImage[10];
    public static BufferedImage timeText;
    public static BufferedImage scoreText;
    public static BufferedImage safety;

    // Kirby Variables
    public static int kirbyX = 30;
    public static int kirbyY = 300;
    public static BufferedImage[] kirbys = new BufferedImage[17];
    public static int kirbyIndex = 0;
    public static int kirbyFrameCounter = 0;
    public static int gravity = 2;
    public static int velocity = -22;
    public static int direction = 1; // 0 is left, 1 is right
    public static int realX = 30; // his real coordinates in respect to the background
    public static int fallvelocity = 0;

    // Movement booleans
    public static boolean isJumping = false;
    public static boolean aPressed = false;
    public static boolean dPressed = false;

    // Game variables
    public static int lives = 3;
    public static int score;
    public static int timer = 200;
    public static int secondCount = 0;
    public static int backgroundX = 0;
    public static int firstPlace;
    public static int secondPlace;
    public static int thirdPlace;
    public static int tutscreen = 0;
    public static int lastScore;

    // Unbreakable Blocks
    public static BufferedImage unBlock;
    public static int[][] originalunBlockCords= {{520, 354}, {572, 354}, {624, 354},
            {572, 306}, {1041, 354}, {1093, 354}, {1145, 354}, {1093, 306}, {572, 0}, {572, 48}, {1611, 354},
            {1093, 0}, {1093, 48}, {572, 96}, {1093, 96}, {2234, 354}, {2286, 354}};
    public static int[][] unBlockCords= new int[originalunBlockCords.length][2];

    public static BufferedImage block;
    public static int[][] originalBlockCords = {{295, 214}, {345, 214}, {395, 214}, {445, 214},
            {295, 100}, {245, 100}, {245, 100}, {195, 100}, {145, 100}, {1225, 214}, {1275, 214}, {1325, 214}, {1375, 214}
            , {1425, 214}, {1475, 214}, {1525, 214}, {1225, 40}, {1275, 40}, {1325, 40}, {1375, 40}
            , {1425, 40}, {1475, 40}, {1525, 40}, {1722, 135}, {1772, 135}, {1822, 135}, {1872, 135},
            {1922, 135}, {1972, 135}, {2022, 135}, {2072, 135}, {2122, 135}, {2410, 254}, {2460, 254},
            {2510, 254}, {2560, 254}, {2630, 140}, {2680, 140}, {2730, 140}, {2780, 140}};
    public static int[][] blockCords = new int[originalBlockCords.length][2];

    // Waddle Dee coordinates
    // index 2 is the left or right, index 3 is alive or dead
    public static BufferedImage[] waddle = new BufferedImage[2];

    // different lists for different stacks
    public static int[][] waddleCords = {{685, 355, 0, 0}, {685, 305, 0, 0}, {685, 255, 0, 0},
            {315, 355, 1, 0}, {315, 305, 1, 0}, {1200, 355, 1, 0}, {1300, 355, 0, 0},
            {870, 355, 1, 0}, {870, 305, 1, 0}, {870, 255, 1, 0}, {870, 205, 1, 0},
            {1700, 355, 0, 0},  {1900, 355, 1, 0}, {2500, 207, 0, 0}, {2630, 95, 0, 0}, {2500, 355, 1, 0}};
    public static int[][] originalWaddleCords = new int[waddleCords.length][4];

    public static void waddleCollision(){
        for (int i=0;i<waddleCords.length;i++){
            if (!(kirbyX+60<waddleCords[i][0]||kirbyX>waddleCords[i][0]+55
                    ||kirbyY+60<waddleCords[i][1]||kirbyY>waddleCords[i][1]+48)&&waddleCords[i][3]==0&&realX>=100) {
                if (((isJumping&&velocity>=0)||(!isJumping&&!downCollision(fallvelocity)))&&kirbyY<=waddleCords[i][1]+48) {
                    if ((i==0&&waddleCords[1][3]==1)||(i==1&&waddleCords[2][3]==1)||(i==2||i==4||i==5||
                            i==6||i==10||i==11||i==12||i==13||i==14||i==15)|| (i==3&&waddleCords[4][3]==1)||
                            (i==7&&waddleCords[8][3]==1)||(i==8&&waddleCords[9][3]==1)||
                    (i==9&&waddleCords[10][3]==1)){
                        for (int x=-10; x<=0;x++){
                            if (!upCollision(x)) {
                                isJumping = true;
                                velocity = x;
                                break;
                            }
                        }
                        score += 200;
                        waddleCords[i][3] = 1;
                    }
                }
                else {
                    resetKirby();
                }
            }
        }
    }

    public static void waddleDee(int i, int leftMost, int rightMost){
        if (waddleCords[i][3]!=1){
            if (waddleCords[i][2]==0) {
                if (waddleCords[i][0]-5<=leftMost+52) {
                    waddleCords[i][2]=1;
                }
                else {
                    waddleCords[i][0] -=6;
                }
            }
            else {
                if (waddleCords[i][0]+50+6>=rightMost) {
                    waddleCords[i][2]=0;
                }
                else {
                    waddleCords[i][0]+=6;
                }
            }
        }
        else if (waddleCords[i][1]<450){
            waddleCords[i][1] += 5;
        }
    }

    // kabu
    public static BufferedImage kabuPic;
    public static int[][] originalKabuCords = {{1277, 35, 0, 0, 0, 0}, {1477, 35, 0, 0, 0, 0}, {1377, 215, 0, 0, 0, 0},
            {1724, 128, 0, 0, 0, 0}, {1824, 240, 0, 0, 0, 0}, {1924, 128, 0, 0, 0, 0}, {2024, 240, 0, 0, 0, 0},
            {2124, 128, 0, 0, 0, 0}};
    public static int[][] kabuCords = {{1277, 35, 0, 0, 0, 0}, {1477, 35, 0, 0, 0, 0}, {1377, 215, 0, 0, 0, 0},
            {1724, 128, 0, 0, 0, 0}, {1824, 240, 0, 0, 0, 0}, {1924, 128, 0, 0, 0, 0}, {2024, 240, 0, 0, 0, 0}, {2124, 128, 0, 0, 0, 0}
            };

    public static void kabu(int i, int highY, int lowY){
        if (kabuCords[i][1]==lowY&&kabuCords[i][2]!=12) {
            if (kabuCords[i][2]%4==0) kabuCords[i][0] += 4;
            else if (kabuCords[i][2]%4-1==0)kabuCords[i][0] -=4;
            kabuCords[i][2]++;
        }
        else if (kabuCords[i][1]+5<=highY){
            kabuCords[i][1]+= kabuCords[i][3];
            if (kabuCords[i][5]%2==0) kabuCords[i][3]++;
            kabuCords[i][5]++;
        }
        else {
            if (kabuCords[i][4]==10){
                kabuCords[i][1] = lowY;
                kabuCords[i][2] = 0;
                kabuCords[i][3] = 0;
                kabuCords[i][4] = 0;
            }
            else kabuCords[i][4]++;
        }
    }

    public static void kabuCollision(){
        for (int i=0;i<kabuCords.length;i++){
            if (!(kirbyX+58<kabuCords[i][0]||kirbyX>kabuCords[i][0]+45
                    ||kirbyY+58<kabuCords[i][1]||kirbyY>kabuCords[i][1]+55)) {
                resetKirby();
            }
        }
    }

    // block collision booleans
    public static boolean upCollision(int vel){
        for (int i=0;i<originalunBlockCords.length;i++){
            if (!(realX+60<originalunBlockCords[i][0]||realX>originalunBlockCords[i][0]+52
                    ||kirbyY+60<originalunBlockCords[i][1]||kirbyY+vel>originalunBlockCords[i][1]+47)) {
                return true;
            }
        }
        for (int i=0;i<originalBlockCords.length;i++){
            if (!(realX+60<originalBlockCords[i][0]||realX>originalBlockCords[i][0]+50
                    ||kirbyY+60<originalBlockCords[i][1]||kirbyY+vel>originalBlockCords[i][1]+44)) {

                return true;
            }
        }
        return false;
    }
    public static boolean downCollision(int vel){
        if (kirbyY+60>=399) {
            return true;
        }
        for (int i=0;i<originalunBlockCords.length;i++){
            if (!(realX+60<originalunBlockCords[i][0]||realX>originalunBlockCords[i][0]+52
                    ||kirbyY+60+vel<originalunBlockCords[i][1]||kirbyY>originalunBlockCords[i][1]+47)) {
                return true;
            }
        }
        for (int i=0;i<originalBlockCords.length;i++){
            if (!(realX+60<originalBlockCords[i][0]||realX>originalBlockCords[i][0]+50
                    ||kirbyY+60+vel<originalBlockCords[i][1]||kirbyY>originalBlockCords[i][1]+44)) {
                return true;
            }
        }
        return false;
    }

    public static boolean leftCollision(){
        for (int i=0;i<originalunBlockCords.length;i++){
            if (!(realX+60<originalunBlockCords[i][0]||realX-5>originalunBlockCords[i][0]+52
                    ||kirbyY+60<originalunBlockCords[i][1]||kirbyY>originalunBlockCords[i][1]+47)) {
                return true;
            }
        }
        for (int i=0;i<originalBlockCords.length;i++){
            if (!(realX+60<originalBlockCords[i][0]||realX-5>originalBlockCords[i][0]+50
                    ||kirbyY+60<originalBlockCords[i][1]||kirbyY>originalBlockCords[i][1]+44)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rightCollision(){
        for (int i=0;i<originalunBlockCords.length;i++){
            if (!(realX+60+5<originalunBlockCords[i][0]||realX>originalunBlockCords[i][0]+52
                    ||kirbyY+60<originalunBlockCords[i][1]||kirbyY>originalunBlockCords[i][1]+47)) {
                return true;
            }
        }
        for (int i=0;i<originalBlockCords.length;i++){
            if (!(realX+60+5<originalBlockCords[i][0]||realX>originalBlockCords[i][0]+50
                    ||kirbyY+60<originalBlockCords[i][1]||kirbyY>originalBlockCords[i][1]+44)) {
                return true;
            }
        }
        return false;
    }

    public static void getHighScores() throws IOException{
        Scanner inputFile = new Scanner(new File("scores.txt"));
        firstPlace = inputFile.nextInt();
        secondPlace = inputFile.nextInt();
        thirdPlace = inputFile.nextInt();
        lastScore = inputFile.nextInt();
        inputFile.close();
        //System.out.println(firstPlace + " " + secondPlace + " " + thirdPlace);
    }
    public static void updateHighScores() throws IOException{
        // there are high scores, if the score is bigger than high score, it overwrites it
        if (score>firstPlace) {
            thirdPlace = secondPlace;
            secondPlace = firstPlace;
            firstPlace = score;
        }
        else if (score > secondPlace) {
            thirdPlace = secondPlace;
            secondPlace = score;
        }
        else if (score>thirdPlace) thirdPlace = score;
        lastScore = score;
        PrintWriter outputFile = new PrintWriter(new FileWriter("scores.txt"));
        outputFile.println(firstPlace);
        outputFile.println(secondPlace);
        outputFile.println(thirdPlace);
        outputFile.println(lastScore);
        outputFile.close();
        //System.out.println(firstPlace + " " + secondPlace + " " + thirdPlace);
    }

    public static void resetLevel() throws IOException{
        score += lives * 300 + timer*5;
        lives = 3;
        for (int x=0;x<waddleCords.length;x++){
            for (int i=0;i<4;i++) waddleCords[x][i] = originalWaddleCords[x][i];
        }
        for (int x=0;x<kabuCords.length;x++){
            for (int i=0;i<5;i++) kabuCords[x][i] = originalKabuCords[x][i];
        }
        kirbyX = 30;
        timer = 200;
        secondCount = 0;
        kirbyY = 300;
        kirbyIndex = 0;
        kirbyFrameCounter = 0;
        velocity = -22;
        direction = 1;
        realX = 30;
        fallvelocity = 0;
        backgroundX = 0;
        //System.out.println(score);
        updateHighScores();
        score = 0;
        for (int x = 0;x<unBlockCords.length;x++){
            unBlockCords[x][0] = originalunBlockCords[x][0];
            unBlockCords[x][1] = originalunBlockCords[x][1];
        }
        for (int x = 0;x<blockCords.length;x++){
            blockCords[x][0] = originalBlockCords[x][0];
            blockCords[x][1] = originalBlockCords[x][1];
        }

    }

    public static void resetKirby(){
        lives--;
        if (lives!=0){
            for (int x=0;x<waddleCords.length;x++){
                waddleCords[x][0] += realX-kirbyX;
            }
            for (int x=0;x<kabuCords.length;x++){
                kabuCords[x][0] += realX-kirbyX;
            }
            kirbyX = 30;
            realX = 30;
            kirbyY = 300;
            backgroundX = 0;
            kirbyIndex = 0;
            isJumping = false;

            for (int x = 0;x<unBlockCords.length;x++){
                unBlockCords[x][0] = originalunBlockCords[x][0];
                unBlockCords[x][1] = originalunBlockCords[x][1];
            }
            for (int x = 0;x<blockCords.length;x++){
                blockCords[x][0] = originalBlockCords[x][0];
                blockCords[x][1] = originalBlockCords[x][1];
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (gamestate==0) {
            g.drawImage(gs0, 0, 0, null);
        }
        else if (gamestate==1) {
            g.drawImage(gs1[tutscreen], 0, 0, null);
        }
        else if (gamestate==2) {
            g.drawImage(gs2, 0, 0, null);
        }
        else if (gamestate==3) {
            g.drawImage(gs3, 0, 0, null);
            // first place
            g.setFont(new Font("American Typewriter", Font.BOLD, 30));
            g.drawString("1. " + firstPlace, 520, 160);
            // second place
            g.drawString("2. " + secondPlace, 520, 230);
            // third place
            g.drawString("3. " + thirdPlace, 520, 300);
            // score
            g.setFont(new Font("American Typewriter", Font.BOLD, 24));
            g.drawString("Last score: " + lastScore, 520, 350);

        }
        else if (gamestate==4) {
            secondCount++;
            if (secondCount%50==0) timer--;
            waddleCollision();
            kabuCollision();

            if (!(realX+60<2870||realX>2970||kirbyY+60<20||kirbyY>120)) {
                gamestate = 5;
                score += 500; // points for beating the game
            }

            if (lives<=0||timer<=0) gamestate = 6; // losing


            if (kirbyY>342) kirbyY = 342; // fixes him sinking into the ground
            if (rightCollision()&&leftCollision()) kirbyY--; // fixes weird up/right/left bug where it gets stuck

            if (isJumping){
                // if there is an upcollision
                if (upCollision(velocity)) velocity = 0;
                kirbyY += velocity;
                velocity += gravity;

                // my amazing jump animation
                if (direction == 1){
                    if (velocity>-13&&velocity<-5) kirbyIndex = 5;
                    else if (8>velocity&&velocity>=-5) kirbyIndex = 6;
                    else if (15>velocity&&velocity>=8) kirbyIndex = 5;
                    else if (velocity>=15) kirbyIndex = 4;
                }
                else {
                    if (velocity>-13&&velocity<-5) kirbyIndex = 8;
                    else if (8>velocity&&velocity>=-5) kirbyIndex = 9;
                    else if (15>velocity&&velocity>=8) kirbyIndex = 8;
                    else if (velocity>=15) kirbyIndex = 7;
                }
                // if there is a downcollision
                if (downCollision(velocity)){
                    isJumping=false;
                    if (aPressed||dPressed){
                        if (direction==0) kirbyIndex = 2;
                        else kirbyIndex = 3;
                    }
                    else {
                        if (direction==0) kirbyIndex = 1;
                        else kirbyIndex = 0;
                    }
                    velocity = -22;
                }

            }
            if (!downCollision(fallvelocity)&&!isJumping){
                kirbyY += fallvelocity;
                fallvelocity += gravity;
            }
            else if (!downCollision(velocity)) fallvelocity = 0;

            if(aPressed) {
                if (!leftCollision()) {
                    if (backgroundX==0&&kirbyX>0||kirbyX>375) {
                        kirbyX -= 5;
                        realX -= 5;
                    }
                    else if (backgroundX<0) {
                        backgroundX += 5;
                        realX -= 5;
                        for (int i=0;i<unBlockCords.length;i++){
                            unBlockCords[i][0]+= 5;
                        }
                        for (int i=0;i<blockCords.length;i++){
                            blockCords[i][0]+= 5;
                        }
                        for (int i=0;i<waddleCords.length;i++){
                            waddleCords[i][0]+= 5;
                        }
                        for (int i=0;i<kabuCords.length;i++){
                            kabuCords[i][0]+= 5;
                        }
                    }
                }

            }
            if(dPressed) {
                if (!rightCollision()){
                    if (kirbyX<375||(backgroundX<=-2200&&kirbyX<750)) {
                        kirbyX += 5;
                        realX += 5;
                    }
                    else if (backgroundX>-2200) {
                        backgroundX = backgroundX - 5;
                        realX += 5;
                        for (int i=0;i<unBlockCords.length;i++){
                            unBlockCords[i][0]-= 5;
                        }
                        for (int i=0;i<blockCords.length;i++){
                            blockCords[i][0]-= 5;
                        }
                        for (int i=0;i<waddleCords.length;i++){
                            waddleCords[i][0]-= 5;
                        }
                        for (int i=0;i<kabuCords.length;i++){
                            kabuCords[i][0]-= 5;
                        }
                    }
                }

            }
            g.drawImage(gs4, backgroundX, 0, null);
            g.drawImage(safety, 10 + backgroundX, 300, null);
            g.drawImage(kirbys[kirbyIndex], kirbyX, kirbyY, null);

            g.drawImage(cookie, 2870 + backgroundX, 20, null);
            // draw blocks
            for (int i=0;i<unBlockCords.length;i++){
                g.drawImage(unBlock, unBlockCords[i][0], unBlockCords[i][1], null);
            }
            for (int i=0;i<blockCords.length;i++){
                g.drawImage(block, blockCords[i][0], blockCords[i][1], null);
            }

            // 0 and 3 are a stack
            // 7-10 are a stack
            // setting up waddle dees
            waddleDee(0, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(1, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(2, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(3, unBlockCords[0][0]-572, unBlockCords[0][0]);
            waddleDee(4, unBlockCords[0][0]-572, unBlockCords[0][0]);
            waddleDee(5, unBlockCords[6][0], unBlockCords[10][0]);
            waddleDee(6, unBlockCords[6][0], unBlockCords[10][0]);
            waddleDee(7, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(8, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(9, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(10, unBlockCords[2][0], unBlockCords[4][0]);
            waddleDee(11, unBlockCords[10][0], unBlockCords[15][0]);
            waddleDee(12, unBlockCords[10][0], unBlockCords[15][0]);
            waddleDee(13, 2345+backgroundX, 2615+backgroundX);
            waddleDee(14, 2565+backgroundX, 2832+backgroundX);
            waddleDee(15, unBlockCords[16][0], 3000+backgroundX);

            // kabus
            kabu(0, 165, 35);
            kabu(1, 165, 35);
            kabu(2,350,215);
            kabu(3,350,128);
            kabu(4,350,128);
            kabu(5,350,128);
            kabu(6,350,128);
            kabu(7,350,128);


            for (int i=0;i<waddleCords.length;i++){
                if (waddleCords[0][2]<450) g.drawImage(waddle[waddleCords[i][2]], waddleCords[i][0], waddleCords[i][1], null);
            }

            if (lives>0) g.drawImage(lifeImages[lives-1], 690, 5, null);

            // drawing the time
            g.drawImage(timeText, 5, 5, null);
            if (timer>99) {
                g.drawImage(numbers[timer/100], 95, 5, null);
                g.drawImage(numbers[(timer/10)%10], 120, 5, null);
                g.drawImage(numbers[timer%10], 145, 5, null);
            }
            else if (timer>9){
                g.drawImage(numbers[timer/10], 95, 5, null);
                g.drawImage(numbers[timer%10], 120, 5, null);
            }
            else g.drawImage(numbers[timer], 95, 5, null);

            // drawing the score
            g.drawImage(scoreText, 320, 5, null);
            if (score<10) g.drawImage(numbers[score], 410, 5, null);
            else if (score<100){
                g.drawImage(numbers[score/10], 410, 5, null);
                g.drawImage(numbers[score%10], 435, 5, null);
            }
            else if (score<999){
                g.drawImage(numbers[score/100], 410, 5, null);
                g.drawImage(numbers[(score/10)%10], 435, 5, null);
                g.drawImage(numbers[score%10], 460, 5, null);
            }
            else{
                g.drawImage(numbers[score/1000], 410, 5, null);
                g.drawImage(numbers[(score/100)%10], 435, 5, null);
                g.drawImage(numbers[(score/10)%10], 460, 5, null);
                g.drawImage(numbers[score%10], 485, 5, null);
            }

            for (int i=0;i<kabuCords.length;i++){
                g.drawImage(kabuPic, kabuCords[i][0], kabuCords[i][1], null);
            }

        }
        else if (gamestate==5) {
            g.drawImage(gs5, 0, 0, null);
        }
        else if (gamestate==6) {
            g.drawImage(gs6, 0, 0, null);
        }
    }
    public void keyPressed(KeyEvent e) {
        // just for now
        if (gamestate==4){
            if(e.getKeyChar()=='a') {
                aPressed = true;
                direction = 0;
                kirbyIndex = 2;
            }
            if(e.getKeyChar()=='d') {
                dPressed = true;
                direction = 1;
                kirbyIndex = 3;
            }
            if(e.getKeyChar()=='w') {
                isJumping = true;

                if (direction == 1) kirbyIndex = 4;
                if (direction == 0) kirbyIndex = 7;
            }
            if (e.getKeyChar() == '+') {
                gamestate=5;
            }
            else if (e.getKeyChar() == '-') {
                gamestate=6;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        kirbyFrameCounter = 0;
        if(e.getKeyChar()=='a') {
            if (!dPressed) kirbyIndex = 1;
            aPressed = false;
        }
        if(e.getKeyChar()=='d') {
            if(!aPressed) kirbyIndex = 0;
            dPressed = false;
        }

    }

    public static void main(String[] args) throws IOException{
        getHighScores();
        // Image Importation
        gs0 = ImageIO.read(new File("menu.png"));
        gs1[0] = ImageIO.read(new File("tutorial0.png"));
        gs1[1] = ImageIO.read(new File("tutorial1.png"));
        gs1[2] = ImageIO.read(new File("tutorial2.png"));
        gs2 = ImageIO.read(new File("credits.png"));
        gs3 = ImageIO.read(new File("highscore.png"));
        //gs4 = ImageIO.read(new File("ingame.png"));
        gs4 = ImageIO.read(new File("background.png"));
        gs5 = ImageIO.read(new File("winning.png"));
        gs6 = ImageIO.read(new File("losing.png"));
        // Sprite Image Importation
        // neutral kirby
        kirbys[0] = ImageIO.read(new File("kirbyneutralright.png"));
        kirbys[1] = ImageIO.read(new File("kirbyneutralleft.png"));
        // kirby moving right or left
        kirbys[2] = ImageIO.read(new File("kirbyleft.png"));
        kirbys[3] = ImageIO.read(new File("kirbyright.png"));
        // kirby jumping
        kirbys[4] = ImageIO.read(new File("kirbyjumpright1.png"));
        kirbys[5] = ImageIO.read(new File("kirbyjumpright2.png"));
        kirbys[6] = ImageIO.read(new File("kirbyjumpright3.png"));
        kirbys[7] = ImageIO.read(new File("kirbyjumpleft1.png"));
        kirbys[8] = ImageIO.read(new File("kirbyjumpleft2.png"));
        kirbys[9] = ImageIO.read(new File("kirbyjumpleft3.png"));

        // blocks
        unBlock = ImageIO.read(new File("unblock.png"));
        block = ImageIO.read(new File("block.png"));

        // waddle dee
        waddle[0] = ImageIO.read(new File("waddledeeleft.png"));
        waddle[1] = ImageIO.read(new File("waddledeeright.png"));

        // kabu
        kabuPic = ImageIO.read(new File("kabu.png"));
        // lives
        lifeImages[0] = ImageIO.read(new File("1life.png"));
        lifeImages[1] = ImageIO.read(new File("2life.png"));
        lifeImages[2] = ImageIO.read(new File("3life.png"));
        // cookie
        cookie = ImageIO.read(new File("cookie.png"));
        // numbers
        numbers[0] = ImageIO.read(new File("0.png"));
        numbers[1] = ImageIO.read(new File("1.png"));
        numbers[2] = ImageIO.read(new File("2.png"));
        numbers[3] = ImageIO.read(new File("3.png"));
        numbers[4] = ImageIO.read(new File("4.png"));
        numbers[5] = ImageIO.read(new File("5.png"));
        numbers[6] = ImageIO.read(new File("6.png"));
        numbers[7] = ImageIO.read(new File("7.png"));
        numbers[8] = ImageIO.read(new File("8.png"));
        numbers[9] = ImageIO.read(new File("9.png"));
        // score and timer
        scoreText = ImageIO.read(new File("scoretext.png"));
        timeText = ImageIO.read(new File("timer.png"));
        safety = ImageIO.read(new File("safety.png"));
        for (int i=0;i<originalBlockCords.length;i++){
            for (int x=0;x<2;x++){
                blockCords[i][x] = originalBlockCords[i][x];
            }
        }
        for (int i=0;i<originalunBlockCords.length;i++){
            for (int x=0;x<2;x++){
                unBlockCords[i][x] = originalunBlockCords[i][x];
            }
        }
        for (int i=0;i<waddleCords.length;i++){
            for (int x=0;x<4;x++){
                originalWaddleCords[i][x] = waddleCords[i][x];
            }
        }
        JFrame frame = new JFrame(("Kirby Kosmos"));
        KirbyKosmos panel = new KirbyKosmos();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public void mousePressed(MouseEvent e){
        //System.out.println("" + e.getX() + " " + e.getY() + " " + realX + " " + kirbyY);
        if (gamestate==0){
            if(e.getX()>=25&&e.getX()<210&&e.getY()>=280&&e.getY()<335) {
                gamestate = 4; //game
            }
            else if(e.getX()>=25&&e.getX()<210&&e.getY()>=365&&e.getY()<420) {
                gamestate = 2; //creds
            }
            else if(e.getX()>=245&&e.getX()<425&&e.getY()>=280&&e.getY()<335){
                gamestate = 1; //tutorial
            }
            else if(e.getX()>=245&&e.getX()<425&&e.getY()>=365&&e.getY()<420){
                gamestate = 3; //highscore
            }
        }
        else if (gamestate==2||gamestate==3){
            if (e.getX()>690&&e.getY()>345) {
                gamestate = 0;
            }
        }
        else if (gamestate==1){
            if (e.getX()>690&&e.getY()>345) {
                gamestate = 0;
            }
            else if (e.getX()>5&&e.getY()>350&&e.getX()<95&&e.getY()<450) {
                if (tutscreen-1>=0)tutscreen--;
                else tutscreen=2;
            }
            else if (e.getX()>420&&e.getY()>350&&e.getX()<505&&e.getY()<450) {
                if (tutscreen+1!=3)tutscreen++;
                else tutscreen=0;
            }
        }
        else if(gamestate==5||gamestate==6){
            if (e.getX()>690&&e.getY()>345) {
                try {
                    resetLevel();
                }
                catch(IOException a){
                    a.printStackTrace();
                }
                gamestate = 4;
            }
            else if (e.getX()<120&&e.getY()>345) {
                try {
                    resetLevel();
                }
                catch(IOException a){
                    a.printStackTrace();
                }
                gamestate = 0;
            }
        }
    }

    public void run() {
        while(true){
            // Screen Freeze
            try{
                Thread.sleep(20);
            }
            catch (Exception e){}
            // Redraw
            repaint();
        }
    }

    // Setting up JPanel
    public KirbyKosmos(){
        setPreferredSize(new Dimension(800, 450));
        this.setFocusable(true);
        // adding mouse and keyListener
        addMouseListener(this);
        addKeyListener(this);
        // adding timer
        Thread thread = new Thread(this);
        thread.start();
    }

    // Useless Methods
    public void keyTyped(KeyEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}