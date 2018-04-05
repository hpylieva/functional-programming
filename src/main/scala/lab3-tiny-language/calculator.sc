sealed trait Expr{
  def eval: Int = this match {
    case Number(n) => n
    case Sum(lOp, rOp) => lOp.eval + rOp.eval
    case Prod(lOp, rOp) => lOp.eval * rOp.eval
    case Var(name) => 0
  }

  def show: String = this match{
    case Number(n) =>  n.toString

    case Sum(lOp, rOp) => lOp.show + " + " + rOp.show

    case Prod(lOp, rOp) => lOp match {
      case Sum(_, _) => rOp match {
        case Sum(_, _) => s"(${lOp.show}) * (${rOp.show})"
        case _ => s"(${lOp.show}) * ${rOp.show}"
      }
      case _ => rOp match {
        case Sum(_, _) => s"${lOp.show} * (${rOp.show})"
        case _ => s"${lOp.show} * ${rOp.show}"
      }
    }

    case Var(name) => name
  }
}

//def show(e: Expr): String

case class Number(n: Int) extends Expr

case class Sum(lOp: Expr, rOp: Expr) extends Expr

case class Prod(lOp: Expr, rOp: Expr) extends Expr

case class Var(name: String) extends Expr



Sum(Number(3),Number(5)).eval
Prod(Number(3),Number(5)).eval
Sum(Number (3), Sum(Number(5), Number(-3))).eval

Sum(Prod(Number(2), Var("x")), Var("y")).show
Prod(Sum(Number(2), Var("x")), Var("y")).show
Prod(Sum(Number(3), Number(6)), Prod(Number(3), Sum(Var("x"), Number(5)))).show
Prod(Sum(Number(3), Number(6)), Var("x")).show