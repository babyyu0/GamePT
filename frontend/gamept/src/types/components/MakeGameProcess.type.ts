export interface IProcessLevel {}
import { IStatObject } from './CharacterCard.types';

export interface ISelectGameMode {
  onGoSelectStory: () => void;
}

export interface ISelectGameStory {
  stories: Array<{
    code: string;
    name: string;
    desc: string;
  }>;
}

export interface ISelectCharacter extends IProcessLevel {
  type: string;
  raceCode?: string;
  gender: number;
  onNextLevel: () => void;
  onPreviosLevel: () => void;
  onSetCharacter: (
    gender: number,
    imgCode: string,
    select: string,
    code: string,
    statList: IStatObject[] | Array<{ statName: string; statBonus: number }>
  ) => void;
  playerStats?: Array<{ statType: string; statValue: number }>;
  data: Array<{
    code: string;
    name: string;
    statList: IStatObject[];
    bonusList: Array<{ statName: string; statBonus: number }>;
  }>;
  statList?: IStatObject[];
}

export interface ICharacterStatus {
  nickname: string;
  race: string;
  raceCode: string;
  job: string;
  jobCode: string;
  gender: number;
  imgCode: string;
  statList: IStatObject[];
  bonusList: Array<{ statName: string; statBonus: number }>;
}

export interface IPostPlayerRequest {
  gameCode: string;
  raceCode: string;
  jobCode: string;
  nickname: string;
}
