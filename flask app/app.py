from flask import Flask, request, jsonify
import joblib

app = Flask(__name__)  # Flask 앱 초기화
model = joblib.load('task_model.pkl')  # 저장된 모델 로드

@app.route('/predict', methods=['POST'])
def predict():
    # JSON 데이터에서 작업 설명을 가져옴
    data = request.json
    description = data['description']
    
    # 모델을 사용해 카테고리 예측
    prediction = model.predict([description])
    
    # 예측된 카테고리를 JSON 형태로 반환
    return jsonify({'category': prediction[0]})

if __name__ == '__main__':
    app.run(port=5000)  # 서버를 5000번 포트에서 실행
