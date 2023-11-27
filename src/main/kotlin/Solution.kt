/**
 * 1~2000 n : 멀리뛰기에 사용될 칸의 수
 *
 * 효진이 한번에 1칸 또는 2칸
 * n이 들어올때 효진이가 뛸수있는 모든 경우의 수를 구한다.
 *
 * n =2
 * 1 1
 * 2 -->  2
 * n = 3
 * 1 1 1
 * 1 2 x2 --> 3
 * ...[1,2] = [3,0],[1,1]
 *            1 + 2
 * n = 4
 * 1 1 1 1
 * 1 1 2 x 3
 * 2 2  ---> 5
 * ...[1,2]= [4,0] , [2,1],[0,2]
 *         = 1 + 3 + 1
 * n = 5 ---> 8
 * 1 1 1 1 1
 * 1 1 1 2 x 4
 * 1 2 2 x 3
 * ....[1,2] = [5,0] ,[3,1],[1,2]
 *           = 1 + 4 + 3 = 8
 * ...인자의 수 만큼 반복된다 --> 즉,1,2 의 갯수의 경우의수를 구한후 식을 산출해 구한다
 *
 * n = 6
 * 1 1 1 1 1 1
 * 1 1 1 1 2 x 5
 * 1 1 2 2 x 4
 * 2 2 2
 * ....[1,2] = [6,0] ,[4,1], [2,2],[0,3]
 *           = 1+ 5 + 4 + 1 = 11개
 * n = 7
 * 1 1 1 1 1 1 1
 * 1 1 1 1 1 2 x 6
 * 1 1 1 2 2 x 5
 * 1 2 2 2 x 4

 * ....[1,2] = [7,0],[5,1],[3,2] [1,3]
 *         = 1+ 6 + 5 + 4 = 16
 * n = k (1<=j<=n/2)
 * k : 짝수
 *  * [1,2] = [k,0],[k-2,1],[k-4,2]...[k-2*j,j]..[0,n/2]
 *          = 1 + k-1 + k-2 + ... + k-j
 * k : 홀수
 *  * [1,2] = = [k,0],[k-2,1],[k-4,2]...[k-2*j,j]..[1,n/2]
 */




class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        var maps = mutableMapOf<Int,Int>()
        var x = 0
        var y = 0
        for(j in 0..n/2){
            x = n-2*j
            y = j
            maps.put(x,y)
        }
        maps.forEach{
            if(it.key==0 || it.value ==0) answer ++
            else answer += (it.key + it.value).toLong()
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