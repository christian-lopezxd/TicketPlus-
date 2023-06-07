import React, { useState } from 'react';
import { QrReader } from 'react-qr-reader';

const Test = (props) => {
  const [data, setData] = useState('No result');


  return (
    <div className=''>
      <QrReader className=''
      

        onResult={(result, error) => {
          if (!!result) {
            setData(result?.text);
          }

          if (!!error) {
            console.info(error);
          }
        }}
        style={{ width: '100%'}}
        facingMode="environment"

      />
      <p className='text-white text-center font-montserrat m-3'>{data}</p>
    </div>
  );
};

export default Test;