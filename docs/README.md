기능 구현 목록
============================

# 1. View
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


----------

# 2. Utils
## Validator
- 유효성 검사 클래스
- InputView에서 입력 받은 사용자 입력 값들과 Controller에서 전달 받는 값들의 유효성 검사를 진행한다.

    ### public static void validateBridegRangeInput(int input)
    - 사용자가 입력한 다리 길이가 유효 범위 내에 있는지 체크 (3 <= input <= 20)
 
    ### public static void validateUpOrDownInput(String input)
    - 사용자가 입력한 이동이 "U" 혹은 "D"인지 확인 (input == U or D)
 
    ### public static void validateGameRestartOrQuitInput(String input)
    - 사용자가 입력한 값이 R(재시작) 혹은 Q(그만하기)인지 확인 (input == R or Q)
 

-----------------------------

# 3. Constants
## Constants
- 입/출력 및 내부에서 사용되는 상수(혹은 변하는 값이 없는 텍스트) 정보 저장용 클래스


-----------------------------

# 4. Controller
## Controller
- Validator 및 service와 연결되어 게임 전체 동작을 컨트롤 하는 클래스

  ### public void startGame()
  - 게임을 시작시키는 메서드
  - 사용자에게 입력값을 받아 다리를 생성하고 게임 실행
  - moveUser() 메서드 실행
 
  ### public void retryGame()
  - 게임을 재시작하는 메서드
  - 사용자 입력값을 받아 게임 재시작 여부 선택
  - startGame() 혹은 endGame() 호출
  - BrideGame.retry() 호출
  ### public void endGame()
  - 게임 종료 메서드
  - 저장된 map 및 play 차수 정보를 OutputView로 전달
  
  ### public void moveUser()
  - 사용자의 이동을 입력받아 실행시킴
  - 입력받은 입력을 통해 맵 제작 메서드 및 게임 진행 체크 메서드 실행
  - BridgeGame.move() 실행
  - 결과로 받은 맵 정보 및 게임 정보를 OutputView로 전달


-----------------------------

# 5. Domain
## Bridge
- 다리 정보를 담을 클래스
- 다리의 정보를 저장 => 일급 컬렉션으로 저장
                        => private final List<String> bridge; 

  ### public Bridge(List<String> bridge)
  - Bridge의 생성자
  - size를 입력받아 다리 생성
 
  ### public List<String> getBridge()
  - 다리 정보값을 가져오는 메서드
 
  ### public boolean isSameUserInputAndBridge(String move, int round)
  - 해당 라운드(index로 사용 가능)의 사용자 이동과 다리의 정답이 같다면 true, 다르다면 false return
<<<<<<< Updated upstream
 
## Player
- Player의 정보를 담을 클래스
- Player의 이동과 선택한 다리를 저장(int try = 0, List<String> move)
 
  ### public void initMove()
  - Player의 이동 정보 초기화
  - moves.add(String move)
 
  ### public void addMove(String move)
  - Player의 이동 정보 저장
  - move.clear();
 
  ### public void addTry()
  - Player의 게임 재시작 횟수를 1회 늘림
  - try++;
=======


## Player
- Player 정보를 담을 클래스
- Player의 이동 및 시도 횟수 저장( List<String> move, int trys = 0 )

  ### public Player()
  - Player 객체 생성자
  - move와 trys를 초기화함

  ### public void initMove()
  - Player의 move를 초기화함
  - 게임 재시작시 사용

  ### public void countTrys()
  - Player의 시도 횟수 추가
  - 게임 재시작시 사용

  ### public void addMove(String move)
  - Player의 이동을 move에 저장

  ### public List<String> getMove()
  - Player의 이동 return

  ### public int getTrys()
  - Player의 시도 횟수 return

  ### public int getRound()
  - Player가 몇 번째 라운드(몇 번째 다리)를 진행중인지 확인
  - move.size() return

>>>>>>> Stashed changes

-----------------
 
# 6. Service
## BridgeGame
  - BridgeGame을 진행하는 service
  - Player 정보 저장

  ### public void move()
  - Player의 이동을 구현한 메서드
  - Player객체에 이동 정보 저장
  - Player.addMove() 활용
    
  ### public void retry()
  - 게임을 재시작하는 메서드
  - Player 객체에 try 정보를 1회 추가해준다
  - Player 객체의 initMove()와 addTry() 활용

## BridgeGame
- BridgeGame의 세부 동작들을 통해 게임을 진행시키는 클래스
- 정답 Bridge와 Player 정보를 저장
- List<String> bridge, Player player

  ### public BridgeGame(List<String> Bridge)
  - BridgeGame 객체 생성자
  - Bridge와 Player 초기화

  ### public int move(String move)
  - 입력받은 이동 정보 저장
  - isGameEnd() 메서드로 이동 후 게임 상황 체크(진행중 or 종료됨)
  - 이동 후 현재 게임의 진행 상황을 숫자로 return(0 : 진행중 | 1 : 승리 | 2 : 패배)

  ### public void retry()
  - 게임 재시작 횟수를 1회 늘림
  - player.countTrys();

  ### public boolean isGameEnd()
  - 게임이 끝났는지 확인하는 메서드
  - 끝났으면 true, 진행중이면 false return

  ### public Player getPlayer()
  - BridgeGame을 진행한 Player 정보 return
  - OutputView에서 출력할 정보를 얻기 위한 메서드


## BridgeMaker
  ### public List<String> makeBridge(int size)
  - Bridge를 만들어서 전달해주는 메서드
  - BridgeRandomNumberGenerator.generate() 메서드를 활용해 랜덤한 값(0 or 1) 입력
  - 랜덤 값을 size만큼 받아 U 혹은 D 형태로 저장
  - 완성된 다리를 return
    
-----------------
 
# 6. Etc
## Application
- main 메서드 실행 클래스

## BridgeRandomNumberGenerator
- 랜덤 다리를 생성하기 위해 사용하는 클래스
- 미리 제공된 클래스


