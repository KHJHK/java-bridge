기능 구현 목록
============================
1. View
-----------------------------
## InputView
- 사용자의 입력을 받는 class
- 다리의 사이즈(숫자), 다리 이동 방향('U' | 'D'), 게임 재시작 여부('R' | 'Q')를 입력받는다.
- Validator 클래스에서 사용자의 Input 값을 받아 유효성을 체크할 예정이다.
  
  ### public String readBridege()
  - 사용자로부터 다리의 크기를 입력받음
  - 입력받은 다리 크기를 return
 
  ### public String readMoving()
  - 사용자로부터 이동을 입력받음
  - 입력받은 사용자 이동을 return
 
  ### public String readGameCommand()
  - 사용자로부터 게임 재시작 여부를 입력받음
  - 입력받은 게임 재시작 여부를 return


## OutputView
- 사용자에게 제공되는 Text를 출력
- 사용자가 볼 수 있는 모든 Text를 출력한다(ERROR 메세지 포함)
- Validator 클래스에서 검증 작업을 거친 data값을 받아서 출력
  
  ### public void printMap(String map)
  - 사용자가 진행한 만큼의 다리를 입력받아 출력.
 
  ### public String printResult(String map, int try)
  - 사용자의 게임 내용을 입력받아 출력

2. Utils
-----------------------------
## Validator
- 유효성 검사 클래스
- InputView에서 입력 받은 사용자 입력 값들과 Controller에서 전달 받는 값들의 유효성 검사를 진행한다.

    ### public static void validateBridegRangeInput(int input)
    - 사용자가 입력한 다리 길이가 유효 범위 내에 있는지 체크 (3 <= input <= 20)
 
    ### public static void validateUpOrDownInput(String input)
    - 사용자가 입력한 이동이 "U" 혹은 "D"인지 확인 (input == U or D)
 
    ### public static void validateGameRestartOrQuitInput(String input)
    - 사용자가 입력한 값이 R(재시작) 혹은 Q(그만하기)인지 확인 (input == R or Q)
 
3. Constants
-----------------------------
## Constants
- 입/출력 및 내부에서 사용되는 상수(혹은 변하는 값이 없는 텍스트) 정보 저장용 클래스

4. Controller
-----------------------------
## Controller
- Validator 및 service와 연결되어 게임 전체 동작을 컨트롤 하는 클래스

  ### public void startGame()
  - 게임을 시작시키는 메서드
  - 사용자에게 입력값을 받아 다리를 생성하고 게임 실행
  - moveUser() 메서드 실행
 
  ### public void reStartGame()
  - 게임을 재시작하는 메서드
  - 사용자 입력값을 받아 게임 재시작 여부 선택
  - startGame() 혹은 endGame() 호출
  ### public void endGame()
  - 게임 종료 메서드
  - 저장된 map 및 play 차수 정보를 OutputView로 전달
  
  ### public void moveUser()
  - 사용자의 이동을 입력받아 실행시킴
  - 입력받은 입력을 통해 맵 제작 메서드 및 게임 진행 체크 메서드 실행
  - 결과로 받은 맵 정보 및 게임 정보를 OutputView로 전달

 5. Domain
-----------------------------
## Bridge
- 다리 정보를 담을 클래스
- 다리의 정보를 저장 => 일급 컬렉션으로 저장
                        => private final List<String> bridge; 

  ### public Bridge(int size)
  - Bridge의 생성자
  - size를 입력받아 다리 생성
 
  ### public List<String> getBridge()
  - 다리 정보값을 가져오는 메서드
 
  ### public boolean isSameUserInputAndBridge(String move, int round)
  - 해당 라운드(index로 사용 가능)의 사용자 이동과 다리의 정답이 같다면 true, 다르다면 false return
 
## User
- 유저의 정보를 담을 클래스
- 유저의 이동과 선택한 다리를 저장(int try = 0, List<String> moves)
 
  ### public void initMove()
  - User의 이동 정보 초기화
  - moves.add(String move)
 
  ### public void addMove(String move)
  - User의 이동 정보 저장
  - moves.clear();
 
  ### public void addTry()
  - User의 게임 재시작 횟수를 1회 늘림
  - try++;
 
 6. Service
-----------------------------
## BridgeGame
## BridgeMaker
## BridgeRandomNumberGenerator

