import axios from 'axios';
import { IPostPlayerRequest } from '@/types/components/MakeGameProcess.type';

const api = import.meta.env.VITE_SERVER_URL;

export const fetchGetRaces = async (gameCode: string) => {
  // 종족 목록 받아오는 get 요청
  const url = api + '/player/race';
  console.log(url, gameCode);
  try {
    const response = await axios.get(url, {
      params: { gameCode },
    });
    console.log('종족 목록', gameCode, response.data);
    return response.data;
  } catch (err) {
    console.log(err, '종족 요청 실패');
  }
};

export const fetchGetJobs = async (gameCode: string) => {
  // 직업 생성하는 post 요청
  const url = api + '/player/job';
  try {
    const response = await axios.get(url, {
      params: { gameCode },
    });
    console.log('직업 목록', gameCode, response.data);

    return response.data;
  } catch {
    console.log('직업 생성 실패');
  }
};

export const fetchPostPlayer = async (request: IPostPlayerRequest) => {
  // 직업 생성하는 post 요청
  const url = api + '/player';
  try {
    const response = await axios.post(url, request);
    console.log('캐릭터 생성', request, response.data);

    return response.data;
  } catch {
    console.log('캐릭터 생성 실패');
  }
};

export const fetchGetSkills = async (playerCode: string) => {
  // 직업 생성하는 post 요청
  const url = api + '???????????';
  try {
    const response = await axios.get(url, {
      params: { playerCode },
    });
    console.log('스킬 목록', playerCode, response.data);

    return response.data;
  } catch {
    console.log('스킬 열람 실패');
  }
};
