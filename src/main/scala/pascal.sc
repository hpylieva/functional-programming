object task1{

  /**
    * Calculates the element of row r and column c in Pascal's Triangle
    */

  def pascal(r: Int, c: Int):Int =
  {
    if(r==c || c==0) 1
    else pascal(r-1, c-1) + pascal(r-1, c)

  }

  pascal(0,0)

  pascal(1,0)
  pascal(1,1)

  pascal(2,0)
  pascal(2,1)
  pascal(2,2)

  pascal(3,0)
  pascal(3,1)
  pascal(3,2)
  pascal(3,3)

  pascal(4,0)
  pascal(4,1)
  pascal(4,2)
  pascal(4,3)
  pascal(4,4)
}