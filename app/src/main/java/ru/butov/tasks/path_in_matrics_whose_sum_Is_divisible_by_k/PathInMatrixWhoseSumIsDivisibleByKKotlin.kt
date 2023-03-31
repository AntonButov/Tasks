package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

class PathInMatrixWhoseSumIsDivisibleByKKotlin {

//  5 2 4    2 2 1
//  3 0 5    0 0 2
//  0 7 2    0 1 2

// k = 3
// r = 2

// 1 + 2 = 0
// 0 + 2 = 2
// 1 + 1 = 2
// 2 + 2 = 1

// 5[2]()  2[2](7)       4[1](11)
// (2)     (1)           (2)
// [0,0,1] `[0,1,0]      [0,0,1]
// 3[0](8) 0[0](7,8)     5[2](12,13,16) (1,2,2)->(0,1,1)
// (2)     (1,2)         (0,1,1)     (0,1,2)->(1,0,1)
// [0,0,1] [0,1,1]       [1,2,0]
// 0[0](8) 7[1](14,15,15) 2[2](18,14,15,16,17,17)
// (2)     (2,0,0)       (0, 2, 0, 1, 2, 2) (2, 0, 2, 0, 1, 1 -> 1, 2, 1, 2, 0, 0)
// [0,0,1] [2,0,1]       [2, 2, 2] [1,0,2]+[1,2,0]=[2,2,2]+[1]->0,1,1,2,2+[1]=1,2,2,0,0=[2,1,2]
//         ([0,0,1]+[0,1,1]->[0,1,2]+[1]=(0,1,2,2)+[1]=(1,2,0,0)=[2,1,1])
//  2  1
// (2) (0)
//  1  0
// (1) (0,1)[0,1,0]

    //  def numberOfPaths(self, grid, K): #Uppercase K to make it different than iterator k in the code
    fun numberOfPaths(grid: List<List<Int>>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size
        val cache: List<MutableList<List<Int>>> = MutableList(m) {
            MutableList(m) {
                List(k) { 0 }
            }
        }
        val smallGrid = grid.mapIndexed { y, value ->
            value.mapIndexed { x, valueX ->
                valueX % k
            }
        }
        smallGrid.forEachIndexed { y, valueY ->
            valueY.forEachIndexed { x, _ ->
                val sumCacheX = if (x > 0) cache[x][y].addCaches(cache[x - 1][y])
                else cache[x][y]
                val sumCacheY = if (y > 0) sumCacheX.addCaches(cache[x][y - 1])
                else sumCacheX
                cache[x][y] = sumCacheY
                    .squash()
                    .addElement(smallGrid[y][x], k)
                    .groupByK(k)
                println("x=$x, y=$y")
                println(cache[x][y])
            }
        }
        return cache[n - 1][m - 1][0]
    }
}
