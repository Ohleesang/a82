/**
 * 1~2000 n : 멀리뛰기에 사용될 칸의 수
 *
 * 효진이 한번에 1칸 또는 2칸
 * n이 들어올때 효진이가 뛸수있는 모든 경우의 수를 구한다.
 *
 * n =2
 * 1 1 2C0 = 1
 * 2 1C1 = 1 -->  2
 * n = 3
 * 1 1 1 3C0 = 1
 * 1 2 2C1 = 2 --> 3
 * ...[1,2] = [3,0],[1,1]
 *            1 + 2
 * n = 4
 * 1 1 1 1
 * 1 1 2 x 3 3C1 = 3
 * 2 2 2C2 =1 ---> 5
 * ...[1,2]= [4,0] , [2,1],[0,2]
 *         = 1 + 3 + 1
 * n = 5 ---> 8
 * 1 1 1 1 1 5C0 = 1
 * 1 1 1 2 x 4 = 4C1 = 4
 * 1 2 2 x 3 3C2 = 3
 * ....[1,2] = [5,0] ,[3,1],[1,2]
 *           = 1 + 4 + 3 = 8
 * ...인자의 수 만큼 반복 된다(x) --> 즉,1,2 의 갯수의 경우의 수를 구한후 식을 산출해 구한다
 *
 * n = 6
 * 1 1 1 1 1 1 6C0 = 1
 * 1 1 1 1 2  5C1 = 5
 * 1 1 2 2  4C2 = 6
 * 2 2 2  3C3 = 1
 * ....[1,2] = [6,0] ,[4,1], [2,2],[0,3]
 *
 * n = 7
 * 1 1 1 1 1 1 1  7C0 = 1
 * 1 1 1 1 1 2   6C1 = 6
 * 1 1 1 2 2    5C2 = 10
 * 1 2 2 2  4C3 = 4

 1 1 1 2 2
 1 1 2 2 1
 1 1 2 1 2
 1 2 2 1 1
 1 2 1 2 1
 1 1 2 2 1  --> 중복
 2 2 1 1 1
 2 1 2 1 1
 1 2 2 1 1  --> 중복
 * ....[1,2] = [7,0],[5,1],[3,2] [1,3]
 *         = 1+ 6 + 5 + 4 = 16
 * n = k (1<=j<=n/2)
 * k : 짝수
 *  * [1,2] = [k,0],[k-2,1],[k-4,2]...[k-2*j,j]..[0,n/2]
 *          = 1 + k-1 + k-2 + ... + k-j
 * k : 홀수
 *  * [1,2] = = [k,0],[k-2,1],[k-4,2]...[k-2*j,j]..[1,n/2]
 *
 *  위의 경우
 *
 *
 *
 *  순열? 조합?
 *  -> 조합  n개의 원소를 갖는 집합에서 r개의 원소를 선택하는 것
 *  즉, 2개의 원소[0,1]를 갖는 집합에서  1,2,3,4,5...개의 원소를 선택(중복x)
 */




class Solution {
    /*
    //재귀함수 이용
    fun comb(n :Int,r:Int):Int{
        var answer = 0
        if(n == r || r ==0) return 1
        answer = comb(n-1,r-1)+comb(n-1,r)
        return answer
    }
     */
    //팩토리얼 이용
    fun fact(n:Int):Long{
        if(n<=1) return 1
        else return n*fact(n-1)
    }
    fun solution(z: Int): Long {
        var answer: Long = 0
        var maps = mutableMapOf<Int,Int>()
        //[1의갯수,2의갯수] 의 모든 경우의수
        var x = 0
        var y = 0
        for(j in 0..z/2){
            x = z-2*j
            y = j
            maps.put(x,y)
        }
        var n = 0
        var r = 0
        var res = 0L
        maps.forEach{
            //계산된 값 answer에 입력
            /*
            if(it.key==0 || it.value ==0) answer ++
            else answer += (it.key + it.value).toLong()
            */
//            answer += comb(it.key+it.value,it.value)

            n = it.key+it.value
            r = it.value

            if(fact(r)*fact(n-r)!=0L) {
                res = fact(n) / (fact(r) * fact(n - r))
            }
            else res =1L
            answer += res
        }


        answer %=1234567
        return answer
    }
}
fun main(){
    var a = Solution()
    var input:String? =""
    while(input!="z"){
        input = readLine()
        println(input?.let { a.solution(it.toInt()) })
    }
}