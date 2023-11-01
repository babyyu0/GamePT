import Input from '@/atoms/Input';
import Prompt from '@/atoms/Prompt';
import { useState } from 'react';
import ChoiceGroup from './ChoiceGroup';

const PromptInterface = () => {
  const [text, setText] = useState('');
  // const testName = '이우석';

  return (
    <div className="relative max-w-[1110px] min-w-[500px] h-[657px] mx-auto border-primary border-4">
      {/* 이 곳에 AI를 통해 생성한 배경 이미지를 백그라운드로 삽입 예정 */}
      <div className="absolute w-full inset-0 bg-[url(./assets/interface/PromptInterface.png)] bg-no-repeat bg-auto pointer-events-none z-10"></div>
      {/* 프롬프트에 data 추가하면 프롬프트 내용 출력 */}
      <Prompt type="in-game" data={null} />
      {/* 선택지 버튼 출력할 Area */}
      <div className="w-full h-[250px] flex justify-center self-center">
        <ChoiceGroup />
      </div>
      {/* 프롬프트 입력할 인풋 */}
      <div className="absolute inset-x-0 bottom-0">
        <Input
          width="full"
          height="45px"
          placeholder="프롬프트를 입력해주세요."
          setValue={(e: string) => setText(e)}
          onClickEvent={() => console.log(text, 'Click!')}
        />
      </div>
    </div>
  );
};

export default PromptInterface;
