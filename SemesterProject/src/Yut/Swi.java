package Yut;

public class Swi extends Thread {

	/**
	 * Swi : 스위치를 관리하는 클래스 스레드를 이용해 항상 run상태를 유지한다. 던지기에 대한 권한을 false로 바꾸면, 버튼을
	 * 사용할수 없게 만든다. 결과선택에 대한 권한을 false로 바꾸면, 버튼을 사용할 수 없게 만든다.
	 */
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 윷결과버튼의 텍스트와 활성화 담당
			for (int i = 0; i < 3; i++) {
				BoardPanel.yutResultButton[i].setText(""
						+ Data.reultOfYut[PlayGame.playUser][i]);
				if (PlayGame.switchOfMoveMalTurn) {
					if (Data.reultOfYut[PlayGame.playUser][i] == 0)
						BoardPanel.yutResultButton[i].setEnabled(false);
					else
						BoardPanel.yutResultButton[i].setEnabled(true);
				}
				else
					BoardPanel.yutResultButton[i].setEnabled(false);
			}

			
			// 윷 던지기 턴이 오면 버튼을 활성화
			if (PlayGame.switchOfThrowYutTurn)
				BoardPanel.throwBtn.setEnabled(true);
			else
				BoardPanel.throwBtn.setEnabled(false);

			
			if(Data.choichResultIndex != -1){
				int index = BoardPanel.mal[PlayGame.playUser][Data.choiceMalIndex].getBoardIndex();
				int result = Data.reultOfYut[PlayGame.playUser][Data.choichResultIndex];
				SelectPan pan = new SelectPan(index);
				int s = pan.select(pan, true, result);
				int l = pan.select(pan, false, result);
				if(s != -1)
					BoardPanel.selectBoard[0].setLocation(BoardPanel.boardPosX[s], BoardPanel.boardPosY[s]);
				else{
					int x = BoardPanel.endPosX[PlayGame.playUser][Data.choiceMalIndex];
					int y = BoardPanel.endPosY[PlayGame.playUser][Data.choiceMalIndex];
					BoardPanel.selectBoard[0].setLocation(x,y);
				}
				if(l != -1)
					BoardPanel.selectBoard[1].setLocation(BoardPanel.boardPosX[l], BoardPanel.boardPosY[l]);
				else{
					int x = BoardPanel.endPosX[PlayGame.playUser][Data.choiceMalIndex];
					int y = BoardPanel.endPosY[PlayGame.playUser][Data.choiceMalIndex];
					BoardPanel.selectBoard[0].setLocation(x,y);
				}
				
				for(int i=0;i<29;i++){
					PlayGame.switchOfBoardClik[i]  =false;
				}
				for(int i=0;i<2;i++){
					for(int j = 0 ; j<3 ; j++){
						PlayGame.switchOfEndBoardClick[i][j]=false;
					}
				}
				
				if(s>=0)
					PlayGame.switchOfBoardClik[s]=true;
				else
					PlayGame.switchOfEndBoardClick[PlayGame.playUser][Data.choiceMalIndex]=true;
				if(l>=0)
					PlayGame.switchOfBoardClik[l]=true;
				else
					PlayGame.switchOfEndBoardClick[PlayGame.playUser][Data.choiceMalIndex]=true;
			}
			else{
				BoardPanel.selectBoard[0].setLocation(620, 320);
				BoardPanel.selectBoard[1].setLocation(690, 320);
				for(int i=0;i<29;i++){
					PlayGame.switchOfBoardClik[i]  =false;
				}
				for(int i=0;i<2;i++){
					for(int j = 0 ; j<3 ; j++){
						PlayGame.switchOfEndBoardClick[i][j]=false;
					}
				}
			}
		}
	}
}
