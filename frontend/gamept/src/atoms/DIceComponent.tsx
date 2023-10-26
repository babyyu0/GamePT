import { useCallback, useEffect } from 'react';
import '../dice.css';
import { IDiceComponent } from '../types/components/DiceComponent.types';

let allVal = {
  x: 0,
  y: 0,
  z: 0,
};

const perFace = [
  [-0.1, 0.3, -1],
  [-0.1, 0.6, -0.4],
  [-0.85, -0.42, 0.73],
  [-0.8, 0.3, -0.75],
  [0.3, 0.45, 0.9],
  [-0.16, 0.6, 0.18],
];

/**
 * throw => 주사위가 던져지는지에 대한 props
 * true면 던져지기, 렌더 시 throw 추적해서 true 값일때면 throw 클래스를 다이스에 붙여주기
 */
const DiceComponent = (props: IDiceComponent) => {
  const setVal1 = useCallback((num: number) => {
    const element: HTMLElement | null = document.querySelector('.dice1');

    if (element !== null) {
      element.style.transform = `rotate3d(${perFace[num - 1]}, 180deg)`;
    }
  }, []);

  const setVal2 = useCallback((num: number) => {
    const element: HTMLElement | null = document.querySelector('.dice2');

    if (element !== null) {
      element.style.transform = `rotate3d(${perFace[num - 1]}, 180deg)`;
    }
  }, []);

  const setVal3 = useCallback((num: number) => {
    const element: HTMLElement | null = document.querySelector('.dice3');

    if (element !== null) {
      element.style.transform = `rotate3d(${perFace[num - 1]}, 180deg)`;
    }
  }, []);

  const setDice = useCallback(() => {
    const elements: HTMLElement | null = document.querySelector('.dice');

    if (elements !== null) {
      elements.style.transform = `rotate3d(${Object.values(allVal)}, 180deg)`;
    }
  }, []);

  const throwDice = useCallback(() => {
    const diceVal1 = props.dice1;
    const diceVal2 = props.dice2;
    const diceVal3 = props.dice3;
    const diceVal = diceVal1 + diceVal2 + diceVal3;
    document.querySelectorAll('.dice').forEach((diceElement) => {
      diceElement.classList.remove('throw');
    });
    setVal1(diceVal1);
    setVal2(diceVal2);
    setVal3(diceVal3);
    const diceValElement: HTMLElement | null =
      document.getElementById('diceVal');

    if (diceValElement !== null) {
      diceValElement.innerHTML = '';
      setTimeout(() => {
        document.querySelectorAll('.dice1').forEach((diceElement) => {
          diceElement.classList.add('throw');
        });
      }, 50);
      setTimeout(() => {
        document.querySelectorAll('.dice2').forEach((diceElement) => {
          diceElement.classList.add('throw');
        });
      }, 125);

      setTimeout(() => {
        document.querySelectorAll('.dice3').forEach((diceElement) => {
          diceElement.classList.add('throw');
        });
      }, 250);
      setTimeout(() => {
        diceValElement.innerHTML = `${diceVal}`;
      }, 700);
    }
  }, [setDice, setVal1, setVal2, setVal3, props]);

  useEffect(() => {
    setDice();
    setVal1(1);
    setVal2(1);
    setVal3(1);
    if (props.throw) throwDice();
  }, [props, setDice, setVal1, setVal2, setVal3]);
  return (
    <div className="diceWrap">
      <div className="dice1 dice">
        <div className="diceFace front"></div>
        <div className="diceFace up"></div>
        <div className="diceFace left"></div>
        <div className="diceFace right"></div>
        <div className="diceFace bottom"></div>
        <div className="diceFace back"></div>
      </div>
      <div className="dice2 dice">
        <div className="diceFace front"></div>
        <div className="diceFace up"></div>
        <div className="diceFace left"></div>
        <div className="diceFace right"></div>
        <div className="diceFace bottom"></div>
        <div className="diceFace back"></div>
      </div>
      <div className="dice3 dice">
        <div className="diceFace front"></div>
        <div className="diceFace up"></div>
        <div className="diceFace left"></div>
        <div className="diceFace right"></div>
        <div className="diceFace bottom"></div>
        <div className="diceFace back"></div>
      </div>
      <span id="diceVal"></span>
    </div>
  );
};

export default DiceComponent;
