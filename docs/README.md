기능 구현 목록
============================
1. View
-----------------------------
## InputView
- 사용자의 입력을 받는 class
- 다리의 사이즈(숫자), 다리 이동 방향('U' | 'D'), 게임 재시작 여부('R' | 'Q')를 입력받는다.
- Validator 클래스에서 사용자의 Input 값을 받아 유효성을 체크할 예정이다.
  
  ### public String readBridege()
  - 사용자로부터 다리의 크기를 입력받는다.
  - 입력받은 다리 크기를 return한다.
 
  ### public String readMoving()
  - 사용자로부터 이동을 입력받는다.
  - 입력받은 사용자 이동을 return한다.
 
  ### public String readGameCommand()
  - 사용자로부터 다리의 크기를 입력받는다.
  - 입력받은 게임 재시작 여부를 return한다.

-------------------------------------------
## OutputView
- 사용자에게 제공되는 Text를 출력한다.
- 사용자가 볼 수 있는 모든 Text를 출력한다(ERROR 메세지 포함)
- Validator 클래스에서 검증 작업을 거친 data값을 받아서 출력한다.
  
  ### public void printMap(String map)
  - 사용자가 진행한 만큼 다리 크기를 
  - 입력받은 다리 크기를 return한다.
 
  ### public String readMoving()
  - 사용자로부터 이동을 입력받는다
  - 입력받은 사용자 이동을 return한다.
 
  ### public String readGameCommand()
  - 사용자로부터 다리의 크기를 입력받는다.
  - 입력받은 게임 재시작 여부를 return한다. 
