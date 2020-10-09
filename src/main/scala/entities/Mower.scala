package entities


class Mower(var initialPlace : Coordinates, var currentPlace : Coordinates, var direction : String, var mvmts :String) {




  def move(action : String ): Unit = {
    if(action.equals(Action.go)) {

    }
    if (action.equals(Action.left)){

    }
    if(action.equals(Action.right)){

    }
  }

}
