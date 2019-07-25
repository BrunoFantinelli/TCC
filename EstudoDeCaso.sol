pragma solidity ^0.4.11;
contract EstudoDeCaso {
	address b;
	address s;
	address k;
	address c;
modifier onlyB(){
	require(msg.sender == b);
	_;
}
modifier onlyS(){
	require(msg.sender == s);
	_;
}
modifier onlyK(){
	require(msg.sender == k);
	_;
}
modifier onlyC(){
	require(msg.sender == c);
	_;
}
}
