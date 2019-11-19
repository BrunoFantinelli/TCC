pragma solidity ^0.5.11;

contract the_matrix {

	enum Stages {
		estado0,
		estado1,
		estado2,
		estado3,
		estado4,
		estado5,
		estado6,
		estado7
	}

	Stages public stage = Stages.estado0;
	address neo;
	address morpheus;
	address smith;

	modifier onlyNEO(){
		require(msg.sender == neo);
		_;
	}

	modifier onlyMORPHEUS(){
		require(msg.sender == morpheus);
		_;
	}

	modifier onlySMITH(){
		require(msg.sender == smith);
		_;
	}

	modifier atStage(Stages _stage) {
		require(stage == _stage);
		_;
	}
function showTrue(){


}

function hideTrue(){


}

function redPill(){
	print("Escolher a pilula vermelha");

}

function bluePill(){


}

function saveWorld(){


}

function destroyMatrix(){


}

function forget(){


}

function liveInIgnorance(){


}

}
